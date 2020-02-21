package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String species,nickname;
    private String [] habits;
    private int tricklevel,age,habitNumber=0;

    Pet(){

    }
    Pet(String species, String nickname){
        this.species=species;
        this.nickname=nickname;
    }
    Pet(String species, String nickname, String []habits, int tricklevel, int age){
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
        String s = String.format("%s{nickname='%s', age=%d, trickLevel=%d, habits=%s}",
                species,nickname,age,tricklevel, Arrays.deepToString(getHabits()));
        return s;
    }

    void setNickname(String nickname){
        this.nickname=nickname;
    }
    String getNickname(){
        return this.nickname;
    }
    void setSpecies(String species){
        this.species=species;
    }
    String getSpecies(){
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
}
