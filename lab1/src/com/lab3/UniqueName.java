package com.lab3;

import java.util.Scanner;

public class UniqueName {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Please enter n:");
        int count = in.nextInt();
        String response ="";
        int cont =0;
        for (int u =1; u<=count; u++){
            System.out.println("Enter name number"+ u);
            String  string = (in.next());
            int out=string.length();
            char[] inp = string.toCharArray();
            for(int i = 0; i < string.length(); i++)
            {

                for (int j = i + 1; j < string.length(); j++) {
                    if (Character.toUpperCase( inp[i]) ==Character.toUpperCase(inp[j])) {
                        out-=1;
                    }
                }
                char ch = string.charAt(i);
                if (ch >= 'A' && ch <= 'Z'){
                    out +=1;
                }
            }
            if (out>cont) {
                cont =out;
                response = string;
            }

        }
        System.out.println( response+ " has the highest uniqueness value "+ cont);
    }
}
