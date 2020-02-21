package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name, surname;
    private int year,iq;
    private Family family;
    String [][] schedule = {{"Monday",""},{"Tuesday",""},{"Wednesday",""},{"Thursday",""},
            {"Friday",""},{"Saturday",""},{"Sunday",""}};

    Human(){

    }
    Human(String name, String surname, int year){
        this.name=name;
        this.surname=surname;
        this.year=year;
    }
    Human(String name, String surname, int year, Family family){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.family=family;
    }
    static {
        System.out.println("Human class is being loaded");
    }
    {
        System.out.println("Object of human class is created");
    }
    void greetPet(){
        System.out.printf("Hello, %s.\n", family.getPet().getNickname());
    }
    void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",family.getPet().getSpecies(),
                family.getPet().getAge(),family.getPet().getTricklevel()>50 ? "very sly" : "almost not sly" );
    }
    public String toString(){
        String s = String.format("Human{name=%s, surname=%s, year=%d, iq=%d, schedule=%s}",
                name,surname,year,iq, Arrays.deepToString(getSchedule()));
        return s;
    }

    boolean feedPet(boolean b){
        if(!b){
            int r = (int) (Math.random()*101);
            if(family.getPet().getTricklevel()<r){
                System.out.printf("I think %s is not hungry.\n",family.getPet().getNickname());
                return false;
            }
        }
        System.out.printf("Hm... I will feed %s.\n",family.getPet().getNickname());
        return true;
    }

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

    void setSchedule (String day, String task) {
        for(int i=0;i<7;i++)
            if(schedule[i][0].equals(day))
                schedule[i][1]=task;
    }

    String  [][]getSchedule (){
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
}






