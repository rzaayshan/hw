package hw10.Human;

import hw10.Family.Family;
import hw10.Pet.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;



    public Human() {

    }

    public Human(String name, String surname, String birthDate){
        this.name=name;
        this.surname=surname;
        this.birthDate=convert(birthDate);
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name=name;
        this.surname=surname;
        this.birthDate=convert(birthDate);
        this.iq=iq;

    }



    Human(String name, String surname, String birthDate, Family family){
        this.name=name;
        this.surname=surname;
        this.birthDate=convert(birthDate);
        this.family=family;
    }

    public Human(String name, String surname, String birthDate, Family family, int iq, Map<DayOfWeek, String> schedule){
        this.name=name;
        this.surname=surname;
        this.birthDate=convert(birthDate);
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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
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

    public String describeAge(){
        Period age = Period.between(toDate(),LocalDate.now());
        return String.format("%d years %d months %d days",age.getYears(),age.getMonths(),age.getDays());
    }

    public LocalDate toDate(){
        return LocalDate.ofInstant(Instant.ofEpochMilli(birthDate), ZoneId.systemDefault());
    }

    Long convert(String birthDate) {
        try{
            Long millis = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate).getTime();
            return millis;}
        catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("Human{name=%s, surname=%s, date of birth=%s, iq=%d, schedule=%s}",
                name, surname,toDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) , iq, schedule);
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
        int result = Objects.hash(name, surname);
        result = (int) (31 * result + iq*birthDate);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object was deleted");
        super.finalize();
    }
}
