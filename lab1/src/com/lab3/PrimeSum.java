package com.lab3;

import java.util.Scanner;

public class PrimeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum =0;
        int read;
        do {
            System.out.print("Enter a number");
            read =in.nextInt();
            sum +=(isPrime(read)) ? read:0;

        }while(read != -1);
        System.out.print("sum of prime is" + sum);
    }
    static boolean isPrime(int n)
    {

        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
