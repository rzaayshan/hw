package hw08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Human mother = new Woman("Xədicə", "Rzayeva", 1971); ;
        Human father = new Man("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);

        Set<String> habits = new HashSet(Arrays.asList("eat","sleep","play"));
        Set<Pet> pet = new HashSet(Arrays.asList(new Dog("Lucky",1, 77,habits)));
        family.setPet(pet);

        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "shopping");
        Human child1 = new Woman("Gülay", "Rzayeva", 1992, family, 90, schedule);
        family.addChild(child1);

        System.out.println(family);
    }
}
