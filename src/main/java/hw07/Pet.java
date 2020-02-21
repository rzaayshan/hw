package hw07;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    String nickname;
    Species species = Species.UNKNOWN;
    String [] habits;
    int tricklevel,age,habitNumber=0;
    Pet(){

    }
    Pet(String nickname){
        this.nickname=nickname;
    }
    Pet(String nickname, String []habits, int tricklevel, int age){
        this.nickname=nickname;
        this.habits=habits;
        this.tricklevel=tricklevel;
        this.age=age;
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
    void setHabits(String habit){
        String []habitsNew = new String[habitNumber+1];
        for(int i=0;i<habitNumber;i++)
            habitsNew[i]=habits[i];
        habitsNew[habitNumber++]=habit;
        habits=habitsNew;
    }

    String []getHabits(){
        return habits;
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
    void eat(){
        System.out.println("I am eating.");
    }
    abstract void respond();
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object of pet is deleted");
        super.finalize();
    }

    enum Species {
        Dog(false,4,true),DomesticCat(false,4,true),
        Fish(false,0,false), Bird(true, 2, false),
        Robocat(false,4, false), UNKNOWN(false,0,false);
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

    }}
