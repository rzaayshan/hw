package hw10.Pet;

import java.util.Set;

public class Fish extends Pet {
    Fish() {
        super();
        this.setSpecies(Species.FISH);
    }

    Fish(String nickname){
        super(nickname);
        this.setSpecies(Species.FISH);
    }

    public Fish(String nickname, int age, int tricklevel, Set<String> habits){
        super(nickname,age,tricklevel,habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", this.getNickname());
    }


}
