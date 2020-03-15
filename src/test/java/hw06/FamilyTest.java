package hw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    Family family;

    @Test
    public void test1(){
        Human mother = new Human("Xədicə", "Rzayeva", 1971);
        Human father = new Human("Alpay", "Rzayev", 1964);
        family = new Family(mother,father);
        Human child1 = new Human("Gülay", "Rzayeva", 1992, family);
        Human child2 = new Human("Nicat", "Rzayev", 1990, family);
        family.addChild(child1);
        family.addChild(child2);
        family.deleteChild(child1);
        Human [] expected = new Human[]{child2};
        Human [] actual = family.getChildren();
        //assertEquals(exception,actual);
        //assertSame(exception,actual);
        for(int i=0;i<expected.length;i++)
            assertTrue(actual[i].equals(expected[i]));


    }




}