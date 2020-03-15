package hw08;

public class Man extends Human {
    Man(){
        super();
    }
    Man(String name, String surname, int year){
        super(name,surname,year);
    }
    Man(String name, String surname, int year, Family family){
        super(name,surname,year,family);
    }
    void greetPet(){
        System.out.printf("Hello, %s.\n, my boy", this.getFamily().getPet().getNickname());
    }
    void fixSomething(){
        System.out.println("We don't need master. I can fix it.");
    }
}
