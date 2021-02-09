package com.lab2;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number");
        int number = scan.nextInt();
        if (number == 0 || number == 1) System.out.printf("factorial is 1");
        else {
            int fact = 1;
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
            System.out.printf(" factorial is "+ fact);
        }
    }
}
