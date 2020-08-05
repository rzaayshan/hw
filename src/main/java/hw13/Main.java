package hw13;

import hw13.Family.FamilyController;
import hw13.Family.FamilyService;
import hw13.Family.FileFamilyDao;
import hw13.Logger.LogDAO;
import hw13.Logger.Logger;


import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogDAO logDAO = new LogDAO("families.log");
        Logger logger = new Logger(logDAO);
        FileFamilyDao familyDao = new FileFamilyDao("families",logger);
        FamilyService service = new FamilyService(familyDao);
        FamilyController controller = new FamilyController(service);
        String command = "";

        while (!command.toLowerCase().equals("exit")){
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
                case "10": controller.getFamilyById(); break;
                /*case "11.1": logController.history();
                case "11.2": logController.historyByDate();*/
                case "exit": break;
                default:
                    System.out.println("Wrong command!");
            }

        }




    }
}
