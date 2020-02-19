package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    enum Species {
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
    private String nickname;
    Species species;
    private String [] habits = new String [5];
    private int tricklevel,age;
    Pet(){

    }
    Pet(Species species, String nickname){
        this.species=species;
        this.nickname=nickname;
    }
    Pet(Species species, String nickname, String []habits, int tricklevel, int age){
        this.species=species;
        this.nickname=nickname;
        this.habits=habits;
        this.tricklevel=tricklevel;
        this.age=age;
    }
    static {
        System.out.println("Pet class is being loaded");
    }
    {
        System.out.println("Object of pet class is created");
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
        String s = String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s, It %s, %s, has %d legs }",
                species.toString(),nickname,age,tricklevel, Arrays.toString(habits),
        species.canFly? "can fly" : "can't fly", species.hasFur? "has fur" : "hasn't fur", species.getNumberOfLegs() );
        return s;
    }

    void setNickname(String nickname){
        this.nickname=nickname;
    }
    String getNickname(){
        return this.nickname;
    }
    void setSpecies(Species species){
        this.species=species;
    }
    Species getSpecies(){
        return this.species;
    }
    void setHabits(String []habits){
        this.habits=habits;
    }
    String []getHabits(){
        return this.habits;
    }
    void setTricklevel(int tricklevel){
        this.tricklevel=tricklevel;
    }
    int getTricklevel(){
        return this.tricklevel;
    }
    void setAge(int age){
        this.age=age;
    }
    int getAge(){
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return  Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname) &&
                Objects.equals(age, pet.age);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, tricklevel, age);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }
    public void finalize() {
        System.out.println("Pet removed");

    }
}
