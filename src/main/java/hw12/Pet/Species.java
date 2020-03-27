package hw12.Pet;

public enum Species {
    DOG(false,4,true),DOMESTICCAT(false,4,true),
    FISH(false,0,false), ROBOCAT(false, 4, false),
    UNKNOWN();

    boolean canFly;
    int numberOfLegs;
    boolean hasFur;

    Species(){

    }

    Species(boolean canFly, int numberOfLegs, boolean hasFur){
        this.canFly=canFly;
        this.numberOfLegs=numberOfLegs;
        this.hasFur=hasFur;
    }

    boolean isCanFly(){
        return canFly;
    }
    int getNumberOfLegs(){
        return numberOfLegs;
    }
    boolean isHasFur(){
        return hasFur;
    }

}

