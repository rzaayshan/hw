package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int tricklevel;
    private String []habits;

    static {
        System.out.println("A new Pet class is created");
    }

    Pet() {
        System.out.println("A new Pet object is created");
    }

    Pet(String species, String nickname){
        this.species=species;
        this.nickname=nickname;
        System.out.println("A new Pet object is created");
    }

    Pet(String species, String nickname, int age, int tricklevel, String []habits){
        this.species=species;
        this.nickname=nickname;
        this.age=age;
        this.tricklevel=tricklevel;
        this.habits=habits;
        System.out.println("A new Pet object is created");
    }

    void eat(){
        System.out.println("I am eating.");
    }

    void respond(){
        System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);
    }

    void foul(){
        System.out.println("I need to cover it up.");
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTricklevel() {
        return tricklevel;
    }

    public void setTricklevel(int tricklevel) {
        this.tricklevel = tricklevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return String.format("%s{nickname=%s, age=%d, trickLevel=%d, habits=%s}",
                species,nickname,age,tricklevel, Arrays.toString(habits));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                tricklevel == pet.tricklevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, tricklevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }
}
