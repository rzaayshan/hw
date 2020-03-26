package hw11;

import hw11.Family.Family;
import hw11.Family.FamilyController;
import hw11.Human.Human;
import hw11.Human.Man;
import hw11.Human.Woman;
import hw11.Pet.Dog;
import hw11.Pet.Fish;
import hw11.Pet.Pet;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FamilyController controller = new FamilyController();

        //family1
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/05/1971");
        Human father1 = new Man("Alpay", "Rzayev", "22/01/1971");
        Family family1 = new Family(mother1,father1);
        controller.createFamily(mother1,father1);

        HashSet habits = new HashSet(Arrays.asList("eat","sleep","play"));
        Pet pet1 = new Dog("Lucky",1, 77,habits);
        controller.addPet(0,pet1);

        Human child1 = new Woman("Gülay", "Rzayeva", "31/11/1997",80);

        controller.adoptChild(family1,child1);
        controller.bornChild(family1,"masculine");


        //family2
        Human mother2 = new Woman("Türkan", "Hacıyeva", "10/10/1975"); ;
        Human father2 = new Man("Nicat", "Hacıyev", "23/03/1975");
        Family family2 = new Family(mother2,father2);
        controller.createFamily(mother2,father2);

        Pet pet2 = new Fish("Nemo",1, 80,new HashSet(Arrays.asList("eat","swim")));
        controller.addPet(1,pet2);
        Human child2 = new Woman("Nigar", "Hacıyeva", "15/05/1992",90);
        controller.adoptChild(family2,child2);

        controller.bornChild(family2,"masculine");
        controller.bornChild(family2,"feminine");

        ///////////////////////////////////////////////////

        controller.count();
        controller.displayAllFamilies();
        controller.getFamiliesBiggerThan(5);
        controller.getFamiliesLessThan(6);
        controller.countFamiliesWithMemberNumber(5);
        controller.deleteAllChildrenOlderThan(10);
        controller.getPet(1);
        controller.deleteFamilyById(1);
        controller.deleteFamily(new Family(mother1,father2));
        System.out.println(child2.describeAge());
    }
}
