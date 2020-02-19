package hw05;

import java.util.Arrays;

public class happyFamily {


    public static void main(String[] args) {
       Human father, mother, child;
       Pet pet = new Pet();
       pet.setNickname("Lucky");
       pet.setHabits("play");
       pet.setAge(1);
       pet.setSpecies("dog");
       pet.setTricklevel(45);
        father = new Human();
        father.setName("Alpay");
        father.setSurname("Rzayev");
        mother = new Human("Xədicə", "Rzayeva", 1971);
        child = new Human("Gülay", "Rzayeva", 1992);
        child.setIq(95);
        Family family = new Family(father,mother);
        family.addChild(child);
        child.family.setPet(pet);
        Human child2 = new Human();
        family.addChild(child2);
        child2.setName("Jale");











    }


}
