package hw08;

import java.util.Map;

public class Man extends Human {
    Man(){
        super();
    }
    Man(String name, String surname,int year){
        super(name,surname,year);
    }
    Man(String name, String surname, int year, Family family){
        super(name,surname,year,family);
    }

    Man(String name, String surname, int year, Family family, int iq, Map<DayOfWeek,String> schedule){
        super(name,surname,year,family,iq,schedule);
    }
    void greetPet(Pet p){
        System.out.printf("Hello my boy, %s.\n", p.getNickname());
    }

    void repair(){
        System.out.println("Bla bla bla");

    }
}
