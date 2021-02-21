package com.HW2;

public class BinaryToDecimal {
    public static void main(String[] args) {
        System.out.println("1001011101  to decimal is " +
                (BinaryToDecimal(1001011101)));
        System.out.println("1001011101  to decimal is " +
                (BinaryToDecimal(1111111111)));

    }

    public static int BinaryToDecimalShort(String  bin){
        return Integer.parseInt(bin,2);
    }
    public static int BinaryToDecimal( int  bin){
        int decimal = 0;
        int n = 0;
        while(true){
            if(bin == 0){
                break;
            } else {
                int temp = bin%10;
                decimal += temp*Math.pow(2, n);
                bin = bin/10;
                n++;
            }
        }
        return decimal;
    }
}
