package hw13.Pet;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public abstract class Pet implements Serializable {
    private String nickname;
    private int age;
    private int tricklevel;
    Set<String> habits;
    private Species species;

    private static final long serialVersionUID = 1L;

    Pet() {
        this.species= Species.UNKNOWN;
    }

    Pet(String nickname) {
        this.nickname = nickname;
        this.species = Species.UNKNOWN;
    }


    Pet(String nickname, int age, int tricklevel, Set<String> habits){
        this.nickname=nickname;
        this.age=age;
        this.tricklevel=tricklevel;
        this.habits=habits;
        this.species= Species.UNKNOWN;
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species.toString(),nickname,age,tricklevel, habits);
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
        System.out.println("Pet.Pet object was deleted");
        super.finalize();
    }

    String prettyFormat(){
        return String.format("Specy:\n%s\nNickname:\n%s\nAge:\n%s\n",species,nickname,age);
    }
}
