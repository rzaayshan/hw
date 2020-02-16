package hw01;

import java.util.Arrays;
import java.util.Scanner;

public class numbers {
    static void game(int num, String name){
        Scanner s = new Scanner(System.in);
        String guessNumber;
        int[] numbers1 = new int[100];
        int i=0;
        while(true){
            guessNumber = s.nextLine();
            while(!isDigit(guessNumber))
                guessNumber = s.nextLine();
            numbers1[i] = Integer.parseInt(guessNumber);
            i++;
            if(compare(Integer.parseInt(guessNumber),num))
                break;
        }
        System.out.printf("Congratulations, %s!\n", name);
        int[] numbers2 = new int [i];
        for(int k=(i-1); k>=0; k--)
            numbers2[k]=numbers1[k];

        bubbleSort(numbers2);
        System.out.print("Your numbers: ");
        System.out.println(Arrays.toString(numbers2));
    }

    static void bubbleSort(int[] a){
        int n = a.length, s;
        boolean flag;
        for(int i=0;i<n;i++){
            flag = false;
            for(int j=0;j<n-1;j++)
                if(a[j]<a[j+1]){
                    s=a[j];
                    a[j]=a[j+1];
                    a[j+1]=s;
                    flag = true;
                }
            if(!flag)
                break;
        }
    }

    static boolean isDigit(String a){
        for (int i=0;i<a.length();i++)
            if(!Character.isDigit(a.charAt(i))){
                System.out.println("Please, enter number!");
                return false;}
        return true;
    }

    static boolean compare(int guess, int ran){
        if(guess>ran)
            System.out.println("Your number is too big. Please, try again.");
        else if(guess<ran)
            System.out.println("Your number is too small. Please, try again.");
        else
            return true;

        return false;}

    static void store(String [][] data){
        String[] questions = {"When was Nizami Ganjavi born?", "When did Titanic sink?", "How many continent are there?",
                "How many planets are there in our solar system?","How many countries are there in the world?"};
        String[] answers = {"1141", "1912", "6", "8","195" };
        for(int i=0;i<5;i++){
            data[i][0] = questions[i];
            data[i][1] = answers[i];
        }
    }


    static boolean checkUnique(int []a,int ran){
        for (int value : a)
            if (value == ran)
                return false;
        return true;
    }

    static void make_ran(int[] a){
        Arrays.fill(a, -1);
        int temp;
        for(int i=0;i<5;){
            temp = (int) (Math.random()*5);
            if(checkUnique(a,temp)){
                a[i]=temp;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        String[][] data = new String[5][2];
        store(data);
        System.out.print("Please, enter your name: ");
        Scanner s =new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Please select game. Write 1 for guessgame/ Write 2 for questions");
        int game = s.nextInt();
        System.out.println("Let the game begin!");

        if(game==1){
            int randomNumber=(int)(Math.random()*101);
            game(randomNumber,name);
        }

        else if(game==2){
            int[] ran = new int [5];
            make_ran(ran);
            for(int j=0;j<5;j++){
                int i=ran[j];
                System.out.println(data[i][0]);
                game(Integer.parseInt(data[i][1]),name);
            }}}



}

