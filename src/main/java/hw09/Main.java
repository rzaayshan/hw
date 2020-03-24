package hw09;

import hw09.Family.*;
import hw09.Human.*;
import hw09.Pet.*;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        CollectionFamilyDao familyDAO = new CollectionFamilyDao();
        FamilyService service = new FamilyService(familyDAO);
        FamilyController controller = new FamilyController(service);

        //family1
        Human mother1 = new Woman("Xədicə", "Rzayeva", 1971);
        Human father1 = new Man("Alpay", "Rzayev", 1971);
        Family family1 = new Family(mother1,father1);
        controller.createFamily(mother1,father1);

        HashSet habits = new HashSet(Arrays.asList("eat","sleep","play"));
        Pet pet1 = new Dog("Lucky",1, 77,habits);
        controller.addPet(0,pet1);

        Human child1 = new Woman("Gülay", "Rzayeva", 1992);
        controller.adoptChild(family1,child1);
        controller.bornChild(family1,"masculine");


        //family2
        Human mother2 = new Woman("Türkan", "Hacıyeva", 1975); ;
        Human father2 = new Man("Nicat", "Hacıyev", 1975);
        Family family2 = new Family(mother2,father2);
        controller.createFamily(mother2,father2);

        Pet pet2 = new Fish("Nemo",1, 80,new HashSet(Arrays.asList("eat","swim")));
        controller.addPet(1,pet2);
        controller.addPet(1,new DomesticCat("Garfield",2,90,new HashSet(Arrays.asList("eat","sleep"))));
        Human child2 = new Woman("Nigar", "Hacıyeva", 1997);
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

    }
}
