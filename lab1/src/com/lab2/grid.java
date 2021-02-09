package com.lab2;

import java.util.Scanner;

public class grid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter row");
        int row = scan.nextInt();
        System.out.printf("Enter column");
        int col = scan.nextInt();
        printtGrid(row,col);

    }


    static void printtGrid(int row, int col) {
        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
                System.out.printf((i*j)+" ");
            }
            System.out.println("");
        }
    }
}