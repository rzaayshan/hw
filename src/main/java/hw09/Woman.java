package hw09;

public class Woman extends Human {
    Woman(){
        super();
    }
    Woman(String name, String surname, int year){
        super(name,surname,year);
    }
    Woman(String name, String surname, int year, Family family){
        super(name,surname,year,family);
    }
    void greetPet(Pet pet){
        System.out.printf("Hello, %s.\n, my little girl", pet.getNickname());
    }
    void makeup(){
        System.out.println("I will be ready in 5 minute.");
    }


}
