package hw08;



public class happyFamily {
    public enum dayOfWeek { Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday }
    public static void main(String[] args) {
        Man man = new Man();
        man.setName("Alpay");
        man.setSurname("Rzayev");
        Woman woman = new Woman("Xədicə", "Rzayeva", 1971);
        Family family = new Family(man,woman);
        Woman child1 = new Woman("Gülay", "Rzayeva", 1992, family);
        Man child2 = new Man("Nicat", "Rzayev", 1990, family);
        RoboCat roboCat = new RoboCat("Lucy");
        roboCat.setHabits("run");
        System.out.println(roboCat.getHabits());
        child1.setSchedule("Monday", "work");
        System.out.println(child1);
        family.addChild(child1);
        family.addChild(child2);
        System.out.println(family.getChildren());
    }


}
