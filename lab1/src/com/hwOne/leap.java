package com.hwOne;
import java.util.*;
public class leap {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 1900; i <2100 ; i+=2) {
            if (i % 4 == 0 && i % 100 != 0 && i % 400 != 0) {
                System.out.println(i + " was a leap year");
                list.add(i);
            }
        }
        System.out.println(" all leap years");
        for (int x: list ) {
            System.out.printf(" "+(x) +" ");
        }

    }
}
