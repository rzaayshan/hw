package hw13.Human;

import hw13.Family.Family;
import hw13.Pet.Pet;

import java.time.LocalDate;
import java.util.Map;

public class Man extends Human {
    public Man(){
        super();
        this.setGender("masculine");
    }

    public Man(String name, String surname, LocalDate birthDate){
        super(name,surname,birthDate);
        this.setGender("masculine");
    }
    Man(String name, String surname, LocalDate birthDate, Family family){
        super(name,surname,birthDate,family);
        this.setGender("masculine");
    }

    Man(String name, String surname, LocalDate birthDate, Family family, int iq, Map<DayOfWeek,String> schedule){
        super(name,surname,birthDate,family,iq,schedule);
        this.setGender("masculine");
    }
    public Man(String name, String surname, LocalDate birthdate, int iq){
        super(name,surname,birthdate,iq);
        this.setGender("masculine");
    }

    void greetPet(Pet p){
        System.out.printf("Hello my boy, %s.\n", p.getNickname());
    }

    void repair(){
        System.out.println("Bla bla bla");

    }
}
