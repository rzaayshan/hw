package hw13.Human;

import hw13.Family.Family;
import hw13.Pet.Pet;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class Human implements Serializable {
    private String name;
    private String surname;
    LocalDate birthDate;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;
    private String gender;

    private static final long serialVersionUID = 1L;

    public Human() {

    }

    public Human(String name, String surname, LocalDate birthDate){
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDate;
    }

    public Human(String name, String surname, LocalDate birthDate, int iq) {
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDate;
        this.iq=iq;

    }

    Human(String name, String surname, LocalDate birthDate, Family family){
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDate;
        this.family=family;
    }

    public Human(String name, String surname, LocalDate birthDate, Family family, int iq, Map<DayOfWeek, String> schedule){
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDate;
        this.family=family;
        this.iq=iq;
        this.schedule=schedule;
    }

    public Human(String name, String surname, LocalDate birthDate, int iq, String gender) {
        this.name=name;
        this.surname=surname;
        this.birthDate=birthDate;
        this.family=family;
        this.iq=iq;
        this.gender=getGender();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String describeAge(){
        Period age = Period.between(birthDate, LocalDate.now());
        return String.format("%d years %d months %d days",age.getYears(),age.getMonths(),age.getDays());
    }

    @Override
    public String toString() {
        return String.format("{name=%s, surname=%s, date of birth=%s, iq=%d, schedule=%s}",
                name, surname,birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthDate);
        result = (int) (31 * result + iq);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object was deleted");
        super.finalize();
    }

    String prettyFormat(){
        return String.format("Name:\n%s\nSurname:\n%s\nDate of birth:\n%s",name,surname,birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}