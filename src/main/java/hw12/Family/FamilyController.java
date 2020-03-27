package hw12.Family;

import hw12.Exceptions.FamilyOverflowException;
import hw12.Exceptions.MinusAgeException;
import hw12.Exceptions.WrongIdException;
import hw12.Human.Human;
import hw12.Human.Man;
import hw12.Human.Woman;
import hw12.Pet.Pet;
import hw12.Random.genRan;

import java.time.LocalDate;
import java.util.Scanner;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(){
        familyService = new FamilyService();
    }


    public void displayAllFamilies(){
        System.out.println("-Families:");
        familyService.displayAllFamilies();
    }

    public void getFamilyById(){
        try{
        System.out.println("Enter ID of family:");
        int id = new Scanner(System.in).nextInt();
        if(id<0 || id> Family.getNum()) throw new WrongIdException();
        System.out.println(familyService.getFamilyById(id));}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void infoFamily(){
        System.out.println("Enter ID of family:");
        int id = new Scanner(System.in).nextInt();
        System.out.println(familyService.InfoFamily(id));
    }

    public void getFamiliesBiggerThan(){
        System.out.println("Enter number:");
        int num = new Scanner(System.in).nextInt();
        System.out.printf("-Families whose members are more than %d:\n", num);
        familyService.getFamiliesBiggerThan(num).forEach(System.out::println);
    }

     public void getFamiliesLessThan(){
        System.out.println("Enter number:");
        int num = new Scanner(System.in).nextInt();
        System.out.printf("-Families whose members are less than %d:\n", num);
        familyService.getFamiliesLessThan(num).forEach(System.out::println);
    }

     public void countFamiliesWithMemberNumber(){
         System.out.println("Enter number:");
         int num = new Scanner(System.in).nextInt();
         System.out.printf("-Count of family whose members equals to %d:\n", num);
         System.out.println(familyService.countFamiliesWithMemberNumber(num));
    }

    public void createFamily(){
        familyService.createNewFamily(createHuman("mother"),createHuman("father"));
    }

    private Human createHuman(String member){
        System.out.printf("Enter information for %s\n",member);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        System.out.println("Enter month:");
        int month = scanner.nextInt();
        System.out.println("Enter day:");
        int day = scanner.nextInt();
        System.out.println("Enter IQ:");
        int iq = scanner.nextInt();
        if(member.equals("mother"))
            return new Woman(name,surname,LocalDate.of(year,month,day),iq);
        else if(member.equals("father"))
            return new Man(name,surname, LocalDate.of(year,month,day),iq);
        else{
            System.out.println("Enter gender:");
            String gender = scanner.nextLine();
            return new Human(name,surname,LocalDate.of(year,month,day),iq,gender);
        }
    }

     public void deleteFamilyById(){
        try{
             int id = new Scanner(System.in).nextInt();
             if(id<0 || id> Family.getNum()) throw new WrongIdException();
             familyService.deleteFamilyById(id);
             System.out.printf("-ID %d deleted.\n",id);
         }
         catch (WrongIdException e){
             System.out.println(e.getMessage());
         }
    }

    public void bornChild(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id of family:");
            int id = scanner.nextInt();
            if(id<0 || id> Family.getNum()) throw new WrongIdException();
            if(familyService.getFamilyById(id).countMembers()==6) throw new FamilyOverflowException();
            int ran = (int) (Math.random()*10);
            String gender;
            String name;
            if(ran>5){
                System.out.println("Enter name for girl:");
                name = new Scanner(System.in).nextLine();
                gender = "feminine";
            }
            else{
                System.out.println("Enter name for boy:");
                name = new Scanner(System.in).nextLine();
                gender = "masculine";
            }
            familyService.bornChild(id,gender,name);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void adoptChild(){
        try{
            System.out.println("Enter ID of family:");
            int id = new Scanner(System.in).nextInt();
            if(id<0 || id> Family.getNum()) throw new WrongIdException();
            if(familyService.getFamilyById(id).countMembers()==6) throw new FamilyOverflowException();
            familyService.adoptChild(id,createHuman("child"));}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllChildrenOlderThan(){
        try{
            System.out.println("Enter age:");
            int age = new Scanner(System.in).nextInt();
            if(age<0) throw new MinusAgeException();
            System.out.printf("Children were deleted older than %d\n",age);
        }
        catch (MinusAgeException e){
            System.out.println(e.getMessage());
        }
    }

    public void count(){
        System.out.printf("-There are %d families.\n", familyService.count());
    }

    public void getPet(int id){
        System.out.printf("-Pets of ID %s:\n",id);
        familyService.getPet(id).forEach(System.out::println);
    }

    public void addPet(int id, Pet pet){
        familyService.addPet(id,pet);
    }

    public void menu(){
        String menu = "1. Fill with test data\n" +
                "2. Display the entire list of families\n" +
                "3. Display a list of families where the number of people is greater than the specified number\n" +
                "4. Display a list of families where the number of people is less than the specified number\n" +
                "5. Calculate the number of families where the number of members is\n" +
                "6. Create a new family\n" +
                "7. Delete a family by its index in the general list\n" +
                "8. Edit a family by its index in the general list\n" +
                "\t1. Give birth to a baby\n" +
                "\t2. Adopt a child\n" +
                "\t3. Return to main menu\n" +
                "9. Remove all children over the age of majority\n" +
                "10. Display family\n" +
                "Exit(exit)\n";
        System.out.println(menu);
    }

    public void randomFamily(){
        for(int i=0;i<4;i++){
            familyService.saveFamily(genRan.randFamily());
        }
        System.out.println("New families were created.");
    }


}
