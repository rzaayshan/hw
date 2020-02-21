package hw05;


import java.util.Arrays;

public class happyFamily {
    public static void main(String[] args) {
        Human father, mother, child1,child2;
        Family family;
        Pet pet ;
        father = new Human();
        father.setName("Alpay");
        father.setSurname("Rzayev");
        mother = new Human("Xədicə", "Rzayeva", 1971);
        family = new Family(father,mother);
        child1 = new Human("Gülay", "Rzayeva", 1992, family);
        child2 = new Human("Nicat", "Rzayev", 1990, family);
        child1.setIq(95);
        pet = new Pet("dog","Lucky",null,88,1);
        family.setPet(pet);
        family.addChild(child1);
        family.addChild(child2);
        //***after adding child***
        System.out.println(family);
        family.deleteChild(child2);
        //**after deleting child
        System.out.println(family);
    }


}
