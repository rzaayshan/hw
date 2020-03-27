package hw13.Human;

import hw13.Family.Family;
import hw13.Pet.Pet;

import java.time.LocalDate;
import java.util.Map;

public class Woman extends Human {
    public Woman(){
        super();
        this.setGender("feminine");
    }
    public Woman(String name, String surname, LocalDate birthDate){
        super(name,surname,birthDate);
        this.setGender("feminine");
    }
    public Woman(String name, String surname, LocalDate birthDate, Family family){
        super(name,surname,birthDate,family);
        this.setGender("feminine");;
    }
    public Woman(String name, String surname, LocalDate birthDate, Family family, int iq, Map<DayOfWeek,String> schedule){
        super(name,surname,birthDate,family,iq,schedule);
        this.setGender("feminine");
    }
    public Woman(String name, String surname, LocalDate birthDate, int iq){
        super(name, surname, birthDate, iq);
        this.setGender("feminine");
    }


    void greetPet(Pet p){
        System.out.printf("Hello sweety, %s.\n", p.getNickname());
    }

    void makeUp(){
        System.out.println("I will be ready in 5 minute.");
    }

}
