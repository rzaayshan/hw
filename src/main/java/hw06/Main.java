package hw06;

public class Main {
    public static void main(String[] args) {
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);

        String []habits = {"eat","sleep","play"};
        Pet pet = new Pet(Species.DOG,"Lucky",1, 77,habits);
        family.setPet(pet);

        String [][] schedule = {{DayOfWeek.MONDAY.name(), "reading"},{DayOfWeek.TUESDAY.name(), "shopping"}};
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        Human child2 = new Human("Nicat", "Rzayev", 1998, family, 80, schedule);
        family.addChild(child2);
        family.deleteChild(child1);

        System.out.println(pet);

        for(int i=0;i<100000;i++){
            Human h = new Human();
        }




    }
}
