package com.lab2;

public class SlashFigure {
    public static void main(String[] args) {
        for(int i = 1; i <= 6; i++) {
            for(int j = 0; j < 2 * i - 2; j++)
                System.out.print("\\");

            for(int j = 0; j < -4 * i + 26; j++)
                System.out.print("!");

            for(int j = 0; j < 2 * i - 2; j++)
                System.out.print("/");

            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(int i = 1; i <= 4; i++) {
            for(int j = 0; j < 2 * i - 2; j++)
                System.out.print("\\");

            for(int j = 0; j < -4 * i + 18; j++)
                System.out.print("!");

            for(int j = 0; j < 2 * i - 2; j++)
                System.out.print("/");

            System.out.println();
        }

    }
}
