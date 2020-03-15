package hw08;

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
    void greetPet(){
        System.out.printf("Hello, %s.\n, my little girl", this.getFamily().getPet().getNickname());
    }
    void makeup(){
        System.out.println("I will be ready in 5 minute.");
    }


}
