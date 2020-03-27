package hw13.Pet;

import java.util.Set;

public class Dog extends Pet {
    Dog() {
        super();
        this.setSpecies(Species.DOG);
    }

    Dog(String nickname){
        super(nickname);
        this.setSpecies(Species.DOG);
    }

    public Dog(String nickname, int age, int tricklevel, Set<String> habits){
        super(nickname,age,tricklevel,habits);
        this.setSpecies(Species.DOG);
    }

    void foul(){
        System.out.println("I need to cover it up.");}

    @Override
    void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", this.getNickname());
    }


}
