package hw01;

import java.util.Arrays;
import java.util.Scanner;

public class numbers {

//*******sorting numbers***********
    static void bubbleSort(int a[]){
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
            if(flag==true)
                break;
        }
    }

 //*********questions and answers************
    static void store(String a[][]){
        String data [][] = new String [5][2];
        String questions [] = {"When was Nizami Ganjavi born?", "When did Titanic sink?", "How many continent are there?",
                "How many planets are there in our solar system?","How many countries are there in the world?"};
        String answers[] = {"1141", "1912", "6", "8","195" };
        for(int i=0;i<5;i++){
            data[i][0] = questions[i];
            data[i][1] = answers[i];
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<2;j++){
                a[i][j]=data[i][j];
            }
        }}

 //*****checking whether numeric or not*******
    static boolean isDigit(String a){
        for (int i=0;i<a.length();i++)
            if(!Character.isDigit(a.charAt(i)))
                return false;
        return true;
    }

 //********asking guess********
    static void guess(int num, String name){
        Scanner scanner = new Scanner(System.in);
        String guess_num;
        int guess_numInt;
        int numbers1[] = new int[100];
        int i=0;
        while(true){
            guess_num = scanner.next();
            while(!isDigit(guess_num)) {
                System.out.println("Please, enter number!");
                guess_num = scanner.next();
            }
            guess_numInt = Integer.parseInt(guess_num);
            numbers1[i] = guess_numInt;
            i++;
            if(guess_numInt>num) {
                System.out.println("Your number is too big. Please, try again.");}
            else if(guess_numInt<num) {
                System.out.println("Your number is too small. Please, try again.");}
            else {
                System.out.printf("Congratulations, %s!\n", name);
                break;
            }}
        int numbers2[] = new int [i];
        for(int k=(i-1); k>=0; k--)
            numbers2[k]=numbers1[k];

        bubbleSort(numbers2);
        System.out.print("Your numbers: ");
        System.out.println(Arrays.toString(numbers2));
    }

//*****making random sequence of answers*******
    static void make_ran(int x[]){
        int temp;
        int a[] = new int [5];
        boolean flag;
        int i=0;
        while(true){
            temp = (int) (Math.random()*5);
            //System.out.println(temp);
            flag = true;
            for(int j=0;j<=i;j++){
                if (temp == a[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                a[i]=temp;
                i++;}
            if(i==4)
                break;
        }
        for (int k=0;k<5;k++) {
            x[k]=a[k];
        }}



    public static void main(String[] args) {
        String data[][] = new String[5][2];
        store(data);

        int ran [] = new int [5];
        make_ran(ran);

        System.out.print("Please, enter your name: ");
        String name = (new Scanner(System.in)).nextLine();
        System.out.println("Let the game begin!");

        for(int j=0;j<5;j++){
            int i=ran[j];
            System.out.println(data[i][0]);
            guess(Integer.parseInt(data[i][1]),name);}}

}
