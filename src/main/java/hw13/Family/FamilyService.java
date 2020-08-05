package hw13.Family;

import hw13.Human.*;
import hw13.Pet.Pet;

import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FamilyService {
    //private CollectionFamilyDao familyDao;
    private FileFamilyDao familyDao;


    public FamilyService(FileFamilyDao familyDao){
        this.familyDao=familyDao;
    }

    Collection<Family> getAllFamilies(){
        return familyDao.getAll();
    }

    void displayAllFamilies(){
        getAllFamilies().forEach(System.out::println);
    }

    Collection<Family> getFamiliesBiggerThan(int num){
        return familyDao.getAllBy(f->f.countMembers()>num);
    }

    Collection<Family> getFamiliesLessThan(int num){
        return familyDao.getAllBy(f->f.countMembers()<num);
    }

    int countFamiliesWithMemberNumber(int num){
        return familyDao.getAllBy(f->f.countMembers()==num).size();
    }

    void createNewFamily(Human mother, Human father){
        familyDao.create(new Family(mother,father));
    }

    void saveFamily(Family family){
        familyDao.create(family);
    }

    /*void saveFamily(Family family){
        familyDao.saveFamily(family);
    }*/

    void deleteFamilyById(int id){
        familyDao.deleteBy(f->f.id==id);
    }


    void bornChild(int id, String gender, String name){
        Optional<Family> added = familyDao.get(id);
        added.ifPresentOrElse(f->f.bornChild(gender,name),()->{System.out.println("There isn't family with this id");return;});
        familyDao.update(id,added.get());
    }

    void adoptChild(int id, Human child){
        Optional<Family> added = familyDao.get(id);
        added.ifPresentOrElse(f->f.addChild(child),()->{System.out.println("There isn't family with this id");return;});
        familyDao.update(id,added.get());
    }

    void deleteAllChildrenOlderThan(int age){
        Collection<Family> families = familyDao.getAll();
        for (Family f : families) {
            List<Human> children = f.getChildren();
            List<Human> saved = children.stream()
                    .filter(oneChild -> ChronoUnit.YEARS.between(oneChild.getBirthDate(), LocalDate.now()) > age)
                    .collect(Collectors.toList());
            f.setChildren(saved);
            familyDao.update(f.getId(), f);
        }
       }

    int count(){
        return familyDao.getAll().size();
    }

    Optional<Family> getFamilyById(int id){
        return familyDao.get(id);
    }

    ArrayList getPet(int id){
        return new ArrayList<>(getFamilyById(id).get().getPet());
    }

    void addPet(int id, Pet pet){
        familyDao.get(id).ifPresent(f->f.getPet().add(pet));
    }


}
