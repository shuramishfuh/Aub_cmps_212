package com.Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DieRollRun {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter interger");
        int number = scanner.nextInt();
        System.out.println("enter file name");
        String fileName = scanner.next();
        PrintStream file = new PrintStream(new File(fileName));
        Die die1 = new Die();
        Die die2 = new Die();
        DicePair dice = new DicePair(die1,die2);
        List list = new ArrayList();
        while (number>0){
            file.println(dice.roll());
            number--;
        }
        file.flush();
        file.close();
    }
}
