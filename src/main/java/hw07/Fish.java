package hw07;

public class Fish extends Pet {
    Fish(){
        super();
    }
    Fish(String nickname){
        super(nickname);
    }
    Fish(String nickname, String []habits, int tricklevel, int age){
        super(nickname,habits,tricklevel,age);
    }
    void respond(){
        System.out.printf("Hello, owner. I am your fish, %s. I miss you!\n",this.nickname);
    }
}
