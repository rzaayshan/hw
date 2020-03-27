package hw12.Family;

import hw12.Human.Human;
import hw12.Pet.Pet;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private CollectionFamilyDao familyDao;

    FamilyService(){
        familyDao = new CollectionFamilyDao();
    }

    List<Family> getAllFamilies(){
        return familyDao.getAllFamilies();
    }

    void displayAllFamilies(){
        getAllFamilies().forEach(System.out::println);
    }

    List<Family> getFamiliesBiggerThan(int num){
        return familyDao.getFamilyBy(f->f.countMembers()>num);
    }

    List<Family> getFamiliesLessThan(int num){
        return familyDao.getFamilyBy(f->f.countMembers()<num);
    }

    int countFamiliesWithMemberNumber(int num){
        return familyDao.getFamilyBy(f->f.countMembers()==num).size();
    }

    void createNewFamily(Human mother, Human father){
        familyDao.saveFamily(new Family(mother,father));
    }

    void saveFamily(Family family){
        familyDao.saveFamily(family);
    }

    void deleteFamilyById(int id){
        familyDao.deleteFamily(id);
    }


    Family bornChild(int id, String gender, String name){
        Family added = familyDao.getFamilyById(id);
        added.bornChild(gender,name);
        return added;
    }


    Family adoptChild(int id, Human child){
        Family added = familyDao.getFamilyById(id);
        added.addChild(child);
        return added;
    }

    void deleteAllChildrenOlderThan(int age){
        List<Family> result = familyDao.getAllFamilies().stream()
                .flatMap(oneFamily -> oneFamily.getChildren().stream()
                        .filter(oneChild -> ChronoUnit.YEARS.between(oneChild.getBirthDate(),LocalDate.now()) > age)
                        .map(Human::getFamily))
                .distinct()
                .collect(Collectors.toList());
        familyDao.setFamilies(result);
       }

    int count(){
        return familyDao.getAllFamilies().size();
    }

    Family getFamilyById(int id){
        return familyDao.getFamilyById(id);
    }
    String InfoFamily(int id){
        return familyDao.getFamilyById(id).prettyFormat();
    }

    List<Pet> getPet(int id){
        return new ArrayList<>(getFamilyById(id).getPet());
    }

    void addPet(int id, Pet pet){
        familyDao.getFamilyById(id).getPet().add(pet);
    }


}
