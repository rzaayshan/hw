package hw07;

public class RoboCat extends Pet {
    RoboCat() {
        super();
        this.setSpecies(Species.ROBOCAT);
    }

    RoboCat(String nickname){
        super(nickname);
        this.setSpecies(Species.ROBOCAT);
    }

    RoboCat(String nickname, int age, int tricklevel, String []habits){
        super(nickname,age,tricklevel,habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    void respond() {
        System.out.printf("Hello, owner. I am %s. I miss you!\n", this.getNickname());
    }


}
