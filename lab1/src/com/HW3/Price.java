package com.HW3;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Price {

    public static void main(String[] args) throws IOException {
        int[] arr= new int[2];
        int counter = 0;
        for (int x: read("input.txt")
             ) {
            arr[counter] = x;
            counter++;
        }
        WRITE_MY_LINE(arr[0],arr[1],"input.txt");
    }
    public static void WRITE_MY_LINE(int amount1, int amount2,String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        float do1 =amount1-(amount1/3);
        float do2 =(amount2-(amount2/3));
        printWriter.println(String.format(" Original Price (in \\$) \\t Discounted   \\t  Equivalent Price (in LL)"));
        printWriter.println(String.format(round(amount1,2) +"\t\t\t\t\t\t" +round(do1,2)+"\t"+
                "\t\t\t\t\t"+"LL " +round(amount1*1508)));
        printWriter.println(String.format(round(amount2,2) +"\t\t\t\t\t\t" +round(do2,2)+"\t"+
                "\t\t\t\t\t"+"LL " +( round(amount2*1508))));

        printWriter.flush();
        printWriter.close();
    }

    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

  public static   int round(int n) {
        // Smaller multiple
        int a = (n / 50) * 50;

        // Larger multiple
        int b = a - 50;

        // Return of closest of two
        return (n - a > b - n)? b : a;
    }
    public static List<Integer > read(String fileName) throws FileNotFoundException {
        Scanner   scanner  =  new Scanner(new File(fileName));
        List<Integer > mon= new ArrayList<Integer>();
        while (scanner.hasNext()){
            mon.add(scanner.nextInt());
        }
        return mon;
    }
}
