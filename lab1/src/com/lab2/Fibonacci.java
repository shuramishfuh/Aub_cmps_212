package com.lab2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("Enter nth term");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println(fibonacci(a));
    }
    static int fibonacci(int number)
    {
        if (number <= 1)
            return number;
        return fibonacci(number-1) + fibonacci(number-2);
    }
}
