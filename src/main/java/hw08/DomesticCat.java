package hw08;

import java.util.Set;

public class DomesticCat extends Pet {
    DomesticCat(){
        super();
    }
    DomesticCat(String nickname){
        super(nickname);
    }
    DomesticCat(String nickname, Set<String> habits, int tricklevel, int age){
        super(nickname,habits,tricklevel,age);
    }
    void respond(){
        System.out.printf("Hello, owner. I am your cat, %s. I miss you!\n",this.nickname);
    }
    void foul(){
        System.out.println("I need to cover it up.\n");
    }
}
