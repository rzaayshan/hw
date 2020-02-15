package hw04;

import java.util.Arrays;

public class Pet {
    String species,nickname;
    String [] habits = new String [5];
    int tricklevel,age;
    Pet(){
        
    }
    Pet(String species, String nickname){
        this.species=species;
        this.nickname=nickname;
    }
    Pet(String species, String nickname, String []habits, int tricklevel, int age){
        this.species=species;
        this.nickname=nickname;
        this.habits=habits;
        this.tricklevel=tricklevel;
        this.age=age;
    }
    
    void eat(){
        System.out.println("I am eating.");
    }
    void respond(){
        System.out.printf("Hello, owner. I am %s. I miss you!\n",this.nickname);
    }
    void foul(){
        System.out.println("I need to cover it up.\n");
    }
    public String toString(){
        String s = String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species,nickname,age,tricklevel, Arrays.toString(habits));
        return s;
    }
}
