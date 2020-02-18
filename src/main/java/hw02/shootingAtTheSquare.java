package hw02;

import java.util.Scanner;

public class shootingAtTheSquare {

    static String [][]makeBoard(String[][] a){
        for(int row=0;row<a.length;row++)
            for(int col=0;col<a.length;col++){
                if(row==0 || col==0)
                    a[row][col]= Integer.toString(Math.max(row,col));
                else
                    a[row][col] = "-";
            }
        return a;}

    static void showBoard(String[][] a){
        for(int row=0;row<6;row++){
            for(int col=0;col<6;col++)
                System.out.printf("%s|",a[row][col]);
            System.out.println();}
    }

    //*****checking input format*****
    static boolean check(String a){
        if(a.equals("")){
            System.out.println("Empty input!");
            return false;}
        for (int i=0;i<a.length();i++)
            if(!Character.isDigit(a.charAt(i))){
                System.out.println("Please, write number!");
                return false;}
        if(Integer.parseInt(a)>5 || Integer.parseInt(a)<0){
            System.out.println("Please, choose number in the range of [1,5]!");
            return false;}
        return true;
    }

    //****checking player shoot target or not*****
    static boolean checkShoot(int y, int x, int [][] target){
        for(int i=0;i<target.length;i++)
            if(target[i][0]==y && target[i][1]==x){
                target[i][0]=0;
                target[i][1]=0;
                return true;}
        return false;
    }

    //*******making random pairs******
    static void make_ran(int [][]a){
        int i=0;
        int x,y;
        while(i<a.length){
            y=(int)(Math.random()*5+1);
            x=(int)(Math.random()*5+1);
            if(checkUnique(a,y,x)){
                a[i][0]=y;
                a[i][1]=x;
                i++;
            }
        } }

    //****checking pair is unique or not****
    static boolean checkUnique(int[][] a, int y, int x){
        for(int i=0;i<a.length;i++)
            if(y==a[i][0])
                if(x==a[i][1])
                    return false;
        return true;
    }

    //******main game*******
    static void shoot(String[][] board, int[][] targets, int targetsnumber){
        Scanner s = new Scanner(System.in);
        String lineS, barS;
        int line, bar,i=0;
        while (true){
            System.out.println("Enter line:");
            lineS = s.nextLine();
            while(!check(lineS)){
                lineS = s.nextLine();
            }
            System.out.println("Enter bar:");
            barS = s.nextLine();
            while(!check(barS)){
                barS = s.nextLine();
            }
            line=Integer.parseInt(lineS);
            bar=Integer.parseInt(barS);
            if(checkShoot(line,bar,targets)){
                board[line][bar]="x";
                i++;
                if(i==targetsnumber){
                    showBoard(board);
                    System.out.print("You have won!");
                    break;}
            }
            else board[line][bar] = "*";
            showBoard(board);
        }
    }

    public static void main(String[] args) {
        String [][] board = new String [6][6];
        System.out.println("How many targets do you want?");
        int targetsNumber = new Scanner(System.in).nextInt();
        int [][] targets = new int [targetsNumber][2];
        makeBoard(board);
        make_ran(targets);
        System.out.println("All set. Get ready to rumble!");
        shoot(board,targets,targetsNumber);
    }
}
