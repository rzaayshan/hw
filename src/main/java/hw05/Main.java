package hw05;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);

        String []habits = {"eat","sleep","play"};
        Pet pet = new Pet("dog","Lucky",1, 77,habits);
        family.setPet(pet);

        String [][] schedule = {{"Monday", "reading"},{"Tuesday", "dsfs"}};
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        Human child2 = new Human("Nicat", "Rzayev", 1998, family, 80, schedule);

        family.addChild(child1);
        family.addChild(child2);
        System.out.println(family);

        family.deleteChild(child1);
        System.out.println(family);
    }
}
