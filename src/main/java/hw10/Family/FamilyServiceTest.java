package hw10.Family;

import hw10.Human.*;
import hw10.Pet.*;
import hw10.Pet.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FamilyServiceTest {
    FamilyService service;
    CollectionFamilyDao familyDAO;

    @BeforeEach
    void setUp(){
        this.familyDAO = new CollectionFamilyDao();
        this.service = new FamilyService(familyDAO);
    }

    @Test
    void test1(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        Family family1 = new Family(mother1,father1);
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);

        List<Family> expected = List.of(family1,family2);
        List<Family> actual = familyDAO.getAllFamilies();
        assertEquals(expected,actual);
    }

    @Test
    void test2(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        Family family1 = new Family(mother1,father1);
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);
        service.bornChild(family2,"masculine");

        assertEquals(List.of(family2), service.getFamiliesBiggerThan(2));
    }

    @Test
    void test3(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        Family family1 = new Family(mother1,father1);
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);
        service.bornChild(family2,"masculine");

        assertEquals(List.of(family1), service.getFamiliesLessThan(3));
    }

    @Test
    void test4(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        Family family1 = new Family(mother1,father1);
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);
        service.bornChild(family2,"masculine");

        int actual = service.countFamiliesWithMemberNumber(2);
        assertEquals(1, actual);
    }

    @Test
    void test5(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        Family family1 = new Family(mother1,father1);
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);
        service.bornChild(family2,"masculine");

        assertEquals(family1, service.deleteFamilyById(0));
    }

    @Test
    void test6(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);
        Human child2 = new Woman("Nigar", "Hacıyeva", "13/11/1997");
        family2.addChild(child2);

        assertEquals(family2, service.adoptChild(family2,child2));
    }

    @Test
    void test7(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        Family family2 = new Family(mother2,father2);
        service.createNewFamily(mother2,father2);
        Human child2 = new Woman("Nigar", "Hacıyeva", "13/11/1997");
        service.adoptChild(family2,child2);

        assertEquals(List.of(child2),service.deleteAllChildrenOlderThan(20) );
    }

    @Test
    void test8(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        service.createNewFamily(mother2,father2);

        assertEquals(2,service.count() );
    }

    @Test
    void test9(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        service.createNewFamily(mother1,father1);
        Human mother2 = new Woman("Türkan", "Hacıyeva", "12/10/1971");
        Human father2 = new Man("Nicat", "Hacıyev", "12/10/1971");
        service.createNewFamily(mother2,father2);

        assertEquals(new Family(mother1,father1),service.getFamilyById(0));
    }

    @Test
    void test10(){
        Human mother1 = new Woman("Xədicə", "Rzayeva", "12/10/1971");
        Human father1 = new Man("Alpay", "Rzayev", "12/10/1971");
        service.createNewFamily(mother1,father1);
        Pet pet1 = new Dog("Lucky",1, 77,new HashSet(Arrays.asList("eat","sleep","play")));
        Pet pet2 = new Fish("Nemo",1, 80,new HashSet(Arrays.asList("eat","swim")));
        service.addPet(0,pet1);
        service.addPet(0,pet2);
        assertEquals(List.of(pet2,pet1),service.getPet(0));
    }

















}