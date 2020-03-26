package hw10.Human;

import hw10.Family.Family;
import hw10.Pet.Pet;

import java.util.Map;

public class Woman extends Human {
    public Woman(){
        super();
    }
    public Woman(String name, String surname, String birthDate){
        super(name,surname,birthDate);
    }
    public Woman(String name, String surname, String birthDate, Family family){
        super(name,surname,birthDate,family);
    }
    public Woman(String name, String surname, String birthDate, Family family, int iq, Map<DayOfWeek,String> schedule){
        super(name,surname,birthDate,family,iq,schedule);
    }
    public Woman(String name, String surname, String birthDate, int IQ){
        super(name, surname, birthDate, IQ);
    }
    void greetPet(Pet p){
        System.out.printf("Hello sweety, %s.\n", p.getNickname());
    }

    void makeUp(){
        System.out.println("I will be ready in 5 minute.");
    }

}
