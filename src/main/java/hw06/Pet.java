package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private Species species;
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

    Pet(Species species, String nickname){
        this.species=species;
        this.nickname=nickname;
        System.out.println("A new Pet object is created");
    }

    Pet(Species species, String nickname, int age, int tricklevel, String []habits){
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

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
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
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s, It %s, %s, has %d legs }",
                species.toString(),nickname,age,tricklevel, Arrays.toString(habits), species.isCanFly() ? "can fly" : "can't fly",
                species.isHasFur() ? "has fur" : "hasn't fur", species.getNumberOfLegs());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname);
        result = 31 * result + age;
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object was deleted");
        super.finalize();
    }
}
