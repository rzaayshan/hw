package hw11.Family;

import hw11.Human.Human;
import hw11.Pet.Pet;

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

    Family deleteFamilyById(int id){
        Family f = familyDao.getFamilyById(id);
        if(familyDao.deleteFamily(id))
            return f;
        return null;
    }

    boolean deleteFamily(Family family){
        return familyDao.deleteFamily(family);
    }

    Family bornChild(Family family, String gender){
        Family added = familyDao.getFamilyBy(f->f.hashCode()==family.hashCode()&&f.equals(family)).get(0);
        added.bornChild(gender);
        return added;
    }

    Family adoptChild(Family family, Human child){
        Family added = familyDao.getFamilyBy(f->(f.hashCode()==family.hashCode()&&f.equals(family))).get(0);
        added.addChild(child);
        return added;
    }

    void deleteAllChildrenOlderThan(int age){
        List<Family> result = familyDao.getAllFamilies().stream()
                .flatMap(oneFamily -> oneFamily.getChildren().stream()
                        .filter(oneChild -> ChronoUnit.YEARS.between(oneChild.toDate(),LocalDate.now()) > 18)
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

    List<Pet> getPet(int id){
        return new ArrayList<>(getFamilyById(id).getPet());
    }

    void addPet(int id, Pet pet){
        familyDao.getFamilyById(id).getPet().add(pet);
    }


}
