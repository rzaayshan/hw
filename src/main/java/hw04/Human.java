package hw04;

import java.util.Arrays;

public class Human {
    String name, surname;
    int year,iq;
    Pet pet;
    Human mother,father;
    String [][] schedule = new String [7][2];
    Human(){

    }
    Human(String name, String surname, int year){
        this.name=name;
        this.surname=surname;
        this.year=year;
    }
    Human(String name, String surname, int year,Human father, Human mother){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.mother=mother;
        this.father=father;
    }

    void greetPet(){
        System.out.printf("Hello, %s.\n", pet.nickname);
    }
    void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",pet.species,
                pet.age,pet.tricklevel>50 ? "very sly" : "almost not sly" );
    }
    public String toString(){
        String s = String.format("Human{name=%s, surname=%s, year=%d, iq=%d, mother=%s %s, father=%s %s, "+
                "pet=%s{nickname=%s, age=%d, trickLevel=%d, habits=%s}}",
                name,surname,year,iq,mother.name,mother.surname,father.name,father.surname,pet.species,
                pet.nickname,pet.age,pet.tricklevel, Arrays.toString(pet.habits));
        return s;

    }

    boolean feedPet(boolean b){
        if(!b){
            int r = (int) (Math.random()*101);
            if(pet.tricklevel<r){
                System.out.printf("I think %s is not hungry.\n",pet.nickname);
                return false;
            }
        }
        System.out.printf("Hm... I will feed %s.\n",pet.nickname);
        return true;
    }
}
