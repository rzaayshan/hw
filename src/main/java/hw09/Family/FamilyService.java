package hw09.Family;

import hw09.Human.*;
import hw09.Pet.Pet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    CollectionFamilyDao familyDao;

    public FamilyService(CollectionFamilyDao familyDao){
        this.familyDao=familyDao;
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
        if(familyDao.deleteFamily(id));
        return f;
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

    List<Human> deleteAllChildrenOlderThan(int age){
       List<Family> families = familyDao.getAllFamilies();
       Iterator<Family> it = families.iterator();
       List<Human> allDeleted = new LinkedList<>();
       while(it.hasNext()){
           Family f = it.next();
           List<Human> children = f.getChildren();
           List<Human> deleted = children.stream().filter(c -> (2020 - c.getYear()) > age).
                   collect(Collectors.toList());
           List<Human> saved = children.stream().filter(c -> (2020 - c.getYear()) < age).
                   collect(Collectors.toList());
           allDeleted.addAll(deleted);
           f.setChildren(saved);
       }
       return allDeleted;
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
