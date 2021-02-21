package com.HW2;

import java.util.Scanner;

public class LengthConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
            display(convert(read(scan)));
            System.out.println("Y or y continues, any other character quits");
           String c =  scan.next();
            if (c.equalsIgnoreCase("y")) continue;
            else break;
        }while (true);

    }
    public static double[] read(Scanner scan){
        System.out.println("Enter feet as an integer");
        double feet = scan.nextInt();
        System.out.println("Enter inches as an double");
        double inches= scan.nextInt();
        double[] ret = {feet,inches} ;
        System.out.println("the value of feet, inches "+feet + inches);
        return ret;
    }
    public static double convert(double[] values){
        return  ((values[0] + (values[1]/12))* 0.3048);
    }
    public static void display(double result){
        System.out.println("converted to meters, centimeters is"+ result);
    }
}
