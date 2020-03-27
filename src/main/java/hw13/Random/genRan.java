package hw13.Random;

import hw13.Family.Family;
import hw13.Human.Human;
import hw13.Human.Man;
import hw13.Human.Woman;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class genRan {

    private static String []boyName = {"Ramin", "Kənan", "Ruslan", "Eldar"};
    private static String []girlName = {"Jalə", "Gülşən", "Aidə", "Zümrüd"};
    private static String []surname = {"Şükürzadə", "Kamilli", "Qurbanzadə", "Cəfərli"};


    private static int random(int max) {
        return (int) (Math.random() * max);
    }
    private static LocalDate date(){
        long minDay = LocalDate.of(1985, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(1992, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
    public static Family randFamily(){
        Human mother = new Woman(girlName[random(4)],surname[random(4)],date());
        Human father = new Man(boyName[random(4)],surname[random(4)],date());
        return new Family(mother,father);
    }

}
