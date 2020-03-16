package hw07;

public class Man extends Human {
    void greetPet(){
        System.out.printf("Hello my boy, %s.\n", this.getFamily().getPet().getNickname());
    }

    void repair(){
        System.out.println("Bla bla bla");

    }
}
