package hw07;

public class Woman extends Human {
    void greetPet(){
        System.out.printf("Hello sweety, %s.\n", this.getFamily().getPet().getNickname());
    }

    void makeUp(){
        System.out.println("I will be ready in 5 minute.");
    }

}
