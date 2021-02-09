package com.hwOne;

import java.util.Scanner;

public class grid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter row");
        int row = scan.nextInt();
        System.out.printf("Enter column");
        int col = scan.nextInt();
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.printf((i+(j*row))+" ");
            }
            System.out.println("");
        }

    }
}
