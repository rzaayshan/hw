package hw03;



import java.util.Scanner;

public class weekPlanner {

    static void createPlanner(String [][] schedule){
        String []days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String []tasks = {"do home work", "go to courses; watch a film","meet friends","go to park","go to shopping","finish reading book","sleep)"};
        for(int i=0;i<7;i++){
            schedule[i][0]=days[i];
            schedule[i][1]=tasks[i];
        }
    }

    static void showTask(String [][]schedule, String day){
        switch(day.replaceAll(" ","").toLowerCase()){
            case "monday":
                System.out.printf("Your tasks for %s: %s\n", schedule[0][0], schedule[0][1]);
                break;
            case "tuesday":
                System.out.printf("Your tasks for %s: %s\n", schedule[1][0], schedule[1][1]);
                break;
            case "wednesday":
                System.out.printf("Your tasks for %s: %s\n", schedule[2][0], schedule[2][1]);
                break;
            case "thursday":
                System.out.printf("Your tasks for %s: %s\n", schedule[3][0], schedule[3][1]);
                break;
            case "friday":
                System.out.printf("Your tasks for %s: %s\n", schedule[4][0], schedule[4][1]);
                break;
            case "saturday":
                System.out.printf("Your tasks for %s: %s\n", schedule[5][0], schedule[5][1]);
                break;
            case "sunday":
                System.out.printf("Your tasks for %s: %s\n", schedule[6][0], schedule[6][1]);
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
            }

        }

    static void changeTask(String [][]schedule, String day){
        System.out.printf("Please, input new tasks for %s.\n",day);
        for(int i=0;i<7;i++)
            if(schedule[i][0].toLowerCase().replaceAll(" ","").equals(day.toLowerCase()))
                schedule[i][1] = new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        String [][]schedule = new String [7][2];
        String day = null;
        Scanner s = new Scanner(System.in);

        createPlanner(schedule);

        while(true){
            System.out.println("Please, input the day of the week: ");
            day = s.nextLine();

            if(day.equals("exit"))
                break;

            else if(day.length()>6 && day.substring(0,6).equals("change"))
                changeTask(schedule, day.substring(7));

            else if(day.length()>10 && day.substring(0,10).equals("reschedule"))
                changeTask(schedule,day.substring(11));

            else
                showTask(schedule,day);}


    }
    }


