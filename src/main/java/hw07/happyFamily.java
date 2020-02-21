package hw07;

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
        woman.makeup();
        roboCat.respond();




    }


}
