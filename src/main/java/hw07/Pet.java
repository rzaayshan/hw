package hw07;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private String nickname;
    private int age;
    private int tricklevel;
    private String []habits;
    private Species species;

    static {
        System.out.println("A new Pet class is created");
    }

    Pet() {
        this.species=Species.UNKNOWN;
        System.out.println("A new Pet object is created");
    }

    Pet(String nickname){
        this.nickname=nickname;
        this.species=Species.UNKNOWN;
        System.out.println("A new Pet object is created");
    }

    Pet(String nickname, int age, int tricklevel, String []habits){
        this.nickname=nickname;
        this.age=age;
        this.tricklevel=tricklevel;
        this.habits=habits;
        this.species=Species.UNKNOWN;
        System.out.println("A new Pet object is created");
    }

    void eat(){
        System.out.println("I am eating.");
    }

    abstract void respond();
        //System.out.printf("Hello, owner. I am %s. I miss you!\n", nickname);


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
                species.toString(),nickname,age,tricklevel, Arrays.toString(habits), species.canFly ? "can fly" : "can't fly",
                species.hasFur ? "has fur" : "hasn't fur", species.getNumberOfLegs() );
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
