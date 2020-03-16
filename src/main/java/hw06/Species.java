package hw06;

public enum Species {
    DOG(false,4,true),CAT(false,4,true),
    FISH(false,0,false), BIRD(true, 2, false);

    boolean canFly;
    int numberOfLegs;
    boolean hasFur;

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

