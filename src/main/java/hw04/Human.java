package hw04;

import java.util.Arrays;

public class Human {
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String [][]schedule;

    Human(){

    }
    Human(String name, String surname,int year){
        this.name=name;
        this.surname=surname;
        this.year=year;
    }
    Human(String name, String surname, int year, Human mother, Human father){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.mother=mother;
        this.father=father;
    }
    Human(String name, String surname, int year, Human mother, Human father, Pet pet, int iq, String [][] schedule){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.mother=mother;
        this.father=father;
        this.pet=pet;
        this.iq=iq;
        this.schedule=schedule;
    }

    void greetPet(){
        System.out.printf("Hello, %s.\n", pet.nickname);
    }

    void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",
                pet.species, pet.age, pet.tricklevel>50?"very sly":"almost not sly");
    }

    boolean feedPet(boolean b){
        if(!b && (int)(Math.random()*101)>pet.tricklevel){
            System.out.printf("I think %s is not hungry.",pet.nickname);
            return false;
        }
        System.out.printf("Hm... I will feed %s.",pet.nickname);
        return true;
    }

    @Override
    public String toString() {
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d, mother=%s %s, father=%s %s, pet=%s, schedule=%s}",
                name,surname,year,iq,mother.name,mother.surname,father.name,father.surname,pet,Arrays.deepToString(schedule));
    }
}
