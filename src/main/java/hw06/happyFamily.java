package hw06;

import java.util.Arrays;

public class happyFamily {
    public enum dayOfWeek { Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday }



    public static void main(String[] args) {

       Human father, mother, child;
       Pet pet = new Pet();
       pet.setNickname("Lucky");
       String []h = {"dsfsdf","sdfsdf","ddfss","sd","sd"};
       pet.setHabits(h);
       pet.setAge(1);
       pet.setSpecies(Pet.Species.DOG);
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
        for(int i=0;i<100000;i++){
            new Human();
        }





    }


}
