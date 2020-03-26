package hw10.Pet;

import java.util.Set;

public class DomesticCat extends Pet{
    DomesticCat() {
        super();
        this.setSpecies(Species.DOMESTICCAT);
    }

    DomesticCat(String nickname){
        super(nickname);
        this.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickname, int age, int tricklevel, Set<String> habits){
        super(nickname,age,tricklevel,habits);
        this.setSpecies(Species.DOMESTICCAT);
    }
    void foul(){
        System.out.println("I need to cover it up.");
    }
    @Override
    void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", this.getNickname());

    }



}
