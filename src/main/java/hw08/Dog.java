package hw08;

import java.util.Set;

public class Dog extends Pet {
    Dog(){
        super();
    }
    Dog(String nickname){
        super(nickname);
    }
    Dog(String nickname, Set<String> habits, int tricklevel, int age){
        super(nickname,habits,tricklevel,age);
    }
    void respond(){
        System.out.printf("Hello, owner. I am your dog, %s. I miss you!\n",this.nickname);
    }
    void foul(){
        System.out.println("I need to cover it up.\n");
    }
}
