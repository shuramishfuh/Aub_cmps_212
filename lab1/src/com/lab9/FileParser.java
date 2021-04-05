package com.lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class exer1 {
    public static void main(String[] args) {
        // test if file is readable
        String file_name = " input file name here"  ;
        File inputFile = new File(file_name);
        if (!inputFile.canRead()) {
            System.out.println("Required input file not found; exiting.\n" + inputFile.getAbsolutePath());
            System.exit(1);
        }
        Scanner scan = null;
        try {
            scan = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // go through char to find parentheses
        Stack<Character> s = new Stack<Character>();
        Scanner sc;
        while(scan.hasNextLine()){
            String a = scan.nextLine().trim();
            if (a.startsWith("//") // ignore comments
                    || a.startsWith("/*")
                    || a.startsWith("*")
                    || a.endsWith("*/")){ continue;}
            else {
                sc = new Scanner(a);
                while (sc.hasNext()) {     // checks for each char  pushes or pops if matching
                    String input = sc.next();

                    for (int i = 0; i < input.length(); i++) {
                        char c = input.charAt(i);
                        switch (c) {

                            case '(':
                            case '{':
                            case '[':
                                s.push(c);
                                break;
                            case ')':
                                if (!s.isEmpty() && s.peek().equals('(')) {
                                    s.pop();
                                } else {
                                    s.push(c);
                                }
                                break;
                            case ']':
                                if (!s.isEmpty() && s.peek().equals('[')) {
                                    s.pop();
                                } else {
                                    s.push(c);
                                }
                                break;
                            case '}':
                                if (!s.isEmpty() && s.peek().equals('{')) {
                                    s.pop();
                                } else {
                                    s.push(c);
                                }
                                break;

                            default:
                                break; // not valid

                        }
                    }
                }

            }
        }
        if (s.empty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
            s.clear();
        }
    }



}
