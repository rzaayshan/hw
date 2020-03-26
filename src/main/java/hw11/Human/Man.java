package hw11.Human;

import hw11.Family.Family;
import hw11.Pet.Pet;

import java.util.Map;

public class Man extends Human {
    public Man(){
        super();
    }
    public Man(String name, String surname, String birthDate){
        super(name,surname,birthDate);
    }
    Man(String name, String surname, String birthDate, Family family){
        super(name,surname,birthDate,family);
    }

    Man(String name, String surname, String birthDate, Family family, int iq, Map<DayOfWeek,String> schedule){
        super(name,surname,birthDate,family,iq,schedule);
    }
    Man(String name, String surname, String birthdate, int iq){
        super(name,surname,birthdate,iq);
    }
    void greetPet(Pet p){
        System.out.printf("Hello my boy, %s.\n", p.getNickname());
    }

    void repair(){
        System.out.println("Bla bla bla");

    }
}
