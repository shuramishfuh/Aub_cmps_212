package com.HW2;

import java.util.Scanner;

public class Internet {
    public static void main(String[] args) {
        int hours;
        char ch;
        Scanner scan = new Scanner(System.in);
        System.out.println("What plan are you subscribed to? ");
        ch = Character.toUpperCase(scan.next().charAt(0));
        System.out.println("How many hours have you consumed");
        hours = scan.nextInt();
        double total_charge =0;
        switch (ch) {
            case 'A' -> {
                if (hours < 10)
                    total_charge = 9.95;
                else
                    total_charge = 9.95 + ((hours - 10) * 2.0);
            }
            case 'B' -> {
                if (hours < 20)
                    total_charge = 13.95;
                else
                    total_charge = 14.95 + ((hours - 20));
            }
            case 'C' -> total_charge = 19.95;
            case 'D' -> {
                System.out.println("Your the boss unlimited internet access");
                System.exit(0);
            }
            default -> System.out.println("not a valid package");
        }
        System.out.println("Monthly bill on Package " + ch + " is: $" +total_charge);
    }
}
