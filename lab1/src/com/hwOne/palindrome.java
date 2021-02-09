package com.hwOne;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("enter word");
            String b = scan.next();
            if (b.toLowerCase().equals("done")) break;
            else{
                if (Palindrome(b))
                    System.out.println("true");
                else
                    System.out.println("false");


            }
        }
    }

    static boolean Palindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
