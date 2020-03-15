package hw08;

import java.util.Set;

public class Fish extends Pet {
    Fish(){
        super();
    }
    Fish(String nickname){
        super(nickname);
    }
    Fish(String nickname, Set<String> habits, int tricklevel, int age){
        super(nickname,habits,tricklevel,age);
    }
    void respond(){
        System.out.printf("Hello, owner. I am your fish, %s. I miss you!\n",this.nickname);
    }
}
