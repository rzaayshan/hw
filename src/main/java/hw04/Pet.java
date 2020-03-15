package hw04;

import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int tricklevel;
    String []habits;

    Pet(){

    }
    Pet(String species, String nickname){
        this.species=species;
        this.nickname=nickname;
    }
    Pet(String species, String nickname, int age, int tricklevel, String []habits){
        this.species=species;
        this.nickname=nickname;
        this.age=age;
        this.tricklevel=tricklevel;
        this.habits=habits;
    }

    void eat(){
        System.out.println("I am eating.");
    }
    void respond(){
        System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
    }
    void foul(){
        System.out.println("I need to cover it up.");
    }

    @Override
    public String toString() {
        return String.format("%s{nickname=%s, age=%d, trickLevel=%d, habits=%s}",
                species,nickname,age,tricklevel, Arrays.toString(habits));
    }
}
