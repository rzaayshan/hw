package hw08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private Human human;

    @Test
    public void testHumanToStr(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "shopping");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);

        String expected = "Human{name=Gülay, surname=Rzayeva, year=1992, iq=90, schedule={TUESDAY=shopping, MONDAY=reading}}";
        String actual = child1.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testPetToStr(){
        Set<String> habits = new HashSet(Arrays.asList("eat","sleep","play"));
        Pet pet = new Dog("Lucky",1, 77,habits);

        String expected = "DOG{nickname='Lucky', age=1, trickLevel=77, habits=[sleep, play, eat], It can't fly, has fur, has 4 legs.}";
        String actual = pet.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testDelChild1(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        family.addChild(child1);
        int l1=family.getChildren().size();

        family.deleteChild(child1);
        int l2=family.getChildren().size();

        assertEquals(l2,l1-1);
    }

    @Test
    public void testDelChild2(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        int l1=family.getChildren().size();

        Human notChild = new Human("Nicat", "Rzayev", 1998);
        family.deleteChild(notChild);
        int l2=family.getChildren().size();

        assertEquals(l2,l1);
    }

    @Test
    public void testDelChild3(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        family.addChild(child1);
        int l1=family.getChildren().size();

        Human deletedChild=family.deleteChild(0);
        int l2=family.getChildren().size();

        assertEquals(l2,l1-1);
        assert(deletedChild.equals(child1));
    }

    @Test
    public void testDelChild4(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        family.addChild(child1);
        int l1=family.getChildren().size();

        family.deleteChild(100);
        int l2=family.getChildren().size();

        assertEquals(l2,l1);
    }

    @Test
    public void testAddChild(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        int l1=family.getChildren().size();

        Human child2 = new Human("Nicat", "Rzayev", 1998);
        family.addChild(child2);

        int l2 = family.getChildren().size();
        assertEquals(l2,l1+1);
        assertEquals(family.getChildren().get(l2-1),child2);
    }

    @Test
    public void testCount(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);
        Map<DayOfWeek,String> schedule = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule);
        Human child2 = new Human("Nicat", "Rzayev", 1998);
        family.addChild(child1);
        family.addChild(child2);

        assertEquals(family.countFamily(),4);
    }

    @Test
    public void testHumanEqual(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);

        Map<DayOfWeek,String> schedule1 = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human human1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule1);

        Map<DayOfWeek,String> schedule2 = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human human2 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule2);

        assert(human1.equals(human2));
    }

    @Test
    public void testHumanHashcode(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1971);
        Family family = new Family(mother,father);

        Map<DayOfWeek,String> schedule1 = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human human1 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule1);

        Map<DayOfWeek,String> schedule2 = Map.of(DayOfWeek.MONDAY, "reading", DayOfWeek.TUESDAY, "fgdfg");
        Human human2 = new Human("Gülay", "Rzayeva", 1992, family, 90, schedule2);

        assert(human1.hashCode()==human2.hashCode());
    }

    @Test
    public void testPetEqual(){
        Set<String> habits1 = new HashSet(Arrays.asList("eat","sleep","play"));
        Pet pet1 = new Dog("Lucky",1, 77,habits1);

        String []habits2 = {"eat","sleep"};
        Pet pet2 = new Dog("Lucky",1, 80,habits1);

        assert (pet1.equals(pet2));
    }

    @Test
    public void testPetHashcode(){
        Set<String> habits1 = new HashSet(Arrays.asList("eat","sleep","play"));
        Pet pet1 = new Dog("Lucky",1, 77,habits1);

        Set<String> habits2 = new HashSet(Arrays.asList("eat","sleep"));
        Pet pet2 = new Dog("Lucky",1, 80,habits2);

        assert (pet1.hashCode()==pet2.hashCode());
    }



}