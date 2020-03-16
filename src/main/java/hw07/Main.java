package hw07;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Xədicə", "Rzayeva", 1971); ;
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);

        String []habits = {"eat","sleep","play"};
        Pet pet = new Dog("Lucky",1, 77,habits);
        family.setPet(pet);

        mother.setIq(80);
        father.setIq(80);
        Human child = family.bornChild();
        System.out.println(child);
        System.out.println(family);
    }
}
