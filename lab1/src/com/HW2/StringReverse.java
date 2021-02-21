package com.HW2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" How many strings would you like to enter?");
        int lines = scan.nextInt();
        List<String> in = new ArrayList<>();
        List<String> out = new ArrayList<>();
        while(lines>0){
        in.add(scan.next());
            lines--;
        }
        for (String x: in) {
           out.add( stringReverse(x));
        }
        for (String u: out) {
            System.out.println(u);
        }
    }
    public static String stringReverse(String str){
        int length = str.length();
        char[] chars = str.toCharArray();
        char[] res = new char[length];
        int j=0;
        for (int i =length-1; i>=0;i--){
            res[j] =chars[i];
            j++;
        }
        return new String(res);
    }
}
