package hw09.Family;

import hw09.Human.Human;
import hw09.Pet.Pet;

public class FamilyController {
    FamilyService familyService;

    public FamilyController(FamilyService familyService){
        this.familyService=familyService;
    }


    public void displayAllFamilies(){
        System.out.println("-Families:");
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int num){
        System.out.printf("-Families whose members are more than %d:\n", num);
        familyService.getFamiliesBiggerThan(num).forEach(System.out::println);
    }

     public void getFamiliesLessThan(int num){
        System.out.printf("-Families whose members are less than %d:\n", num);
        familyService.getFamiliesLessThan(num).forEach(System.out::println);
    }

     public void countFamiliesWithMemberNumber(int num){
         System.out.printf("-Count of family whose members equals to %d:\n", num);
         System.out.println(familyService.countFamiliesWithMemberNumber(num));
    }

    public void createFamily(Human mother, Human father){ familyService.createNewFamily(mother,father);
    }

     public void deleteFamilyById(int id){
        System.out.printf("-ID %d deleted: \n",id);
        System.out.println(familyService.deleteFamilyById(id));
    }

    public void deleteFamily(Family family){
        if(familyService.deleteFamily(family))
            System.out.println("-Family deleted.");
        else
            System.out.println("-There isn't this family.");
    }

    public void bornChild(Family family, String gender){
        familyService.bornChild(family,gender);
    }

    public void adoptChild(Family family, Human child){
        familyService.adoptChild(family,child);
    }

    public void deleteAllChildrenOlderThan(int age){
        System.out.printf("-Deleted children which are older than %s:\n",age);
        familyService.deleteAllChildrenOlderThan(age).forEach(System.out::println);
    }

    public void count(){
        System.out.printf("-There are %d families.\n", familyService.count());
    }

    public void getPet(int id){
        System.out.printf("-Pets of ID %s:\n",id);
        familyService.getPet(id).stream().forEach(System.out::println);
    }

    public void addPet(int id, Pet pet){
        familyService.addPet(id,pet);
    }


}
