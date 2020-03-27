package hw12;

import hw12.Family.FamilyController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyController controller = new FamilyController();
        String command = new String();

        while (!command.equals("exit")){
            controller.menu();
            command = new Scanner(System.in).nextLine();
            switch (command){
                case "1": controller.randomFamily();break;
                case "2": controller.displayAllFamilies(); break;
                case "3": controller.getFamiliesBiggerThan(); break;
                case "4": controller.getFamiliesLessThan(); break;
                case "5": controller.countFamiliesWithMemberNumber(); break;
                case "6": controller.createFamily(); break;
                case "7": controller.deleteFamilyById(); break;
                case "8.1": controller.bornChild(); break;
                case "8.2": controller.adoptChild(); break;
                case "8.3": break;
                case "9": controller.deleteAllChildrenOlderThan(); break;
                case "10": controller.infoFamily(); break;
                case "exit": break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }
}
