package hw10.Pet;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    private String nickname;
    private int age;
    private int tricklevel;
    Set<String> habits;
    private Species species;

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
        return String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s, It %s, %s, has %d legs.}",
                species.toString(),nickname,age,tricklevel, habits, species.canFly ? "can fly" : "can't fly",
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
        System.out.println("Pet.Pet object was deleted");
        super.finalize();
    }
}
