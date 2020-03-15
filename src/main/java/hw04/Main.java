package hw04;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);

        String []habits = {"eat","sleep","play"};
        Pet pet = new Pet("dog","Lucky",1, 77,habits);

        String [][] schedule = {{"Monday", "reading"},{"Tuesday", "dsfs"}};
        Human child = new Human("Gülay", "Rzayeva", 1992, mother, father,pet, 80, schedule);

        System.out.println(child);
        child.describePet();
        child.greetPet();

        System.out.println(pet);
        pet.respond();
        pet.eat();
        pet.foul();

        child.feedPet(true);



    }
}
