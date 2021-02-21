package com.HW2;

import java.util.Scanner;

public class BankAudi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nwhat is your bill amount : ");
        double bill = scan.nextDouble();
        System.out.println("\nEnter the monthly payment (in $) : ");
        double pay =scan.nextDouble();
        System.out.println("\nEnter the interest rate (as percentage) : ");
        double rate =scan.nextDouble();

        double paid = 0;
        int i = 0;
        while (bill >= 0) {
            i++;
            bill += bill * (rate / 100);
            bill = bill - pay;
            paid = paid + pay;
            System.out.println("Month :" + i + "  balance : " + String.format("%.2f", bill) + "    Total Payments : " + paid);
        }
    }
}
