package hw08;

import java.util.Map;

public class Woman extends Human {
    Woman(){
        super();
    }
    Woman(String name, String surname,int year){
        super(name,surname,year);
    }
    Woman(String name, String surname, int year, Family family){
        super(name,surname,year,family);
    }

    Woman(String name, String surname, int year, Family family, int iq, Map<DayOfWeek,String> schedule){
        super(name,surname,year,family,iq,schedule);
    }
    void greetPet(Pet p){
        System.out.printf("Hello sweety, %s.\n", p.getNickname());
    }

    void makeUp(){
        System.out.println("I will be ready in 5 minute.");
    }

}
