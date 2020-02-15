package hw04;

public class happyFamily {
    public static void main(String[] args) {
        Human father, mother, child;
        Pet pet;

        father = new Human();
        father.name="Alpay";
        father.surname="Rzayev";
        mother = new Human("Xədicə", "Rzayeva", 1971);
        child = new Human("Gülay", "Rzayeva", 1992, father,mother);
        child.iq=95;

        pet = new Pet("dog","Lucky",null,88,1);
        String h[] = {"sleep","eat","play"};
        pet.habits = h;
        child.pet=pet;

        child.describePet();
        child.greetPet();
        System.out.println(child.toString());

        pet.eat();
        pet.respond();
        pet.foul();
        System.out.println(pet.toString());

        boolean x = child.feedPet(false);

    }

}
