package com.lab3;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your string"+ "\n");
        String string = in.next();
        boolean run =true;
        while(run){
            System.out.print("The current string is " + string + "\n");
            System.out.print("Make choice"+ "\n");
            System.out.print("1- Delete character"+ "\n");
            System.out.print("2- Flip character"+ "\n");
            System.out.print("3- Exit"+ "\n");
            int option = in.nextInt();
            String result;
            int index;
            switch (option){
                case 1:
                    System.out.print("Enter the character’s index"+ "\n");
                    index = in.nextInt();
                    result = removeLetter(index,string);
                    string = (result.length()>0)?result:string;

                case 2:
                    System.out.print("Enter the character’s index"+ "\n");
                    index = in.nextInt();
                    result = Flipcharacter(index,string);
                    string = (result.length()>0)?result:string;

                case 3: run= false;

                default:
                    System.out.print("Enter a valid option"+ "\n");
            }

        }
        System.out.print("Bye!");

    }
    static String removeLetter(int index, String string) {
        if (index > string.length() || index <0) {
            System.out.print("Index is out of bounds");
            return "";
        } else {
            StringBuilder a = new StringBuilder(string);
            return a.deleteCharAt(index).toString();
        }
    }
    static String Flipcharacter(int index, String string){
        if (index > string.length() || index <0) {
            System.out.print("Index is out of bounds");
            return "";
        } else {
            StringBuilder a = new StringBuilder(string);
            a.setCharAt(index,Character.toUpperCase( a.charAt(index)));
            return a.toString();
        }
    }

    }

