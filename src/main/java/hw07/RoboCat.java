package hw07;

public class RoboCat extends Pet {
    RoboCat(){
        super();
    }
    RoboCat(String nickname){
        super(nickname);
    }
    RoboCat(String nickname, String []habits, int tricklevel, int age){
        super(nickname,habits,tricklevel,age);
    }
    @Override
    void respond(){
        System.out.printf("Hello, owner. I am your Robocat, %s. I miss you!\n",this.nickname);
    }
    void foul(){
        System.out.println("I need to cover it up.\n");
    }
}
