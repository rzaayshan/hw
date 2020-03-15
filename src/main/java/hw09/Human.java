package hw09;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name, surname;
    private int year,iq;
    private Family family;
    Map <String, String> schedule;

    Human(){
        createSchedule();
    }
    Human(String name, String surname, int year){
        this.name=name;
        this.surname=surname;
        this.year=year;
        createSchedule();
    }
    Human(String name, String surname, int year, Family family){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.family=family;
        createSchedule();
    }
    static {
        System.out.println("Human class is being loaded");
    }
    {
        System.out.println("Object of human class is created");
    }
    void greetPet(Pet pet){
        if(family.getPet().contains(pet)){
            System.out.printf("Hello, %s.\n", pet.getNickname());
        }
    }

    void describePet(Pet pet){
        if(family.getPet().contains(pet)){
            System.out.printf("I have a %s, he is %d years old, he is %s.\n",pet.getSpecies(),
                    pet.getAge(),pet.getTricklevel()>50 ? "very sly" : "almost not sly" );
        }
    }
    public String toString(){
        String s = String.format("Human{name=%s, surname=%s, year=%d, iq=%d, schedule=%s}",
                name,surname,year,iq, schedule);
        return s;
    }

   /* boolean feedPet(Pet pet, boolean b){
        if(!b){
            int r = (int) (Math.random()*101);
            if(family.getPet().equals(pet).getTricklevel()<r){
                System.out.printf("I think %s is not hungry.\n",family.getPet().getNickname());
                return false;
            }
        }
        System.out.printf("Hm... I will feed %s.\n",family.getPet().getNickname());
        return true;
    }*/

    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
    void setSurname(String surname){
        this.surname=surname;
    }
    String getSurname(){
        return this.surname;
    }
    void setYear(int year){
        this.year=year;
    }
    int getYear(){
        return this.year;
    }
    void setIq(int iq){
        this.iq=iq;
    }
    int getIq(){
        return this.iq;
    }

    void createSchedule(){
        schedule = new HashMap<>();
        String []days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        for(String el:days){
            schedule.put(el,"");
        }
    }

    void setSchedule (String day, String task) {
        schedule.replace(day,task);
    }

    Map <String,String> getSchedule (){
        return schedule;
    }

    void setFamily(Family family){
            this.family=family;
    }
    Family getFamily(){
        return family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year);
        result = 31 * result ;
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object of human is deleted");
        super.finalize();
    }
}






