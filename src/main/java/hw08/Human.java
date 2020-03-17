package hw08;

import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    static {
        System.out.println("A new Human class is created");
    }

    Human() {
        System.out.println("A new Human object is created");

    }

    Human(String name, String surname,int year){
        this.name=name;
        this.surname=surname;
        this.year=year;
        System.out.println("A new Human object is created");
    }
    Human(String name, String surname, int year, Family family){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.family=family;
        System.out.println("A new Human object is created");
    }

    Human(String name, String surname, int year, Family family, int iq, Map<DayOfWeek,String> schedule){
        this.name=name;
        this.surname=surname;
        this.year=year;
        this.family=family;
        this.iq=iq;
        this.schedule=schedule;
        System.out.println("A new Human object is created");
    }

    void greetPet(Pet p){
        System.out.printf("Hello, %s.\n", p.getNickname());
    }

    void describePet(Pet p){
        System.out.printf("I have a %s, he is %d years old, he is %s.\n",
                p.getSpecies(), p.getAge(), p.getTricklevel()>50?"very sly":"almost not sly");
    }

    boolean feedPet(Pet p, boolean b){
        if(!b && (int)(Math.random()*101)>p.getTricklevel()){
            System.out.printf("I think %s is not hungry.",p.getNickname());
            return false;
        }
        System.out.printf("Hm... I will feed %s.",p.getNickname());
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d, schedule=%s}",
                name, surname, year, iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Human human = (Human) o;
        return year == human.year &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname);
        result = 31 * result + iq*year;
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object was deleted");
        super.finalize();
    }
}
