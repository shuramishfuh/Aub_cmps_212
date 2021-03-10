package com.HW4;

public class RationalTest {
    public static void main(String[] args) {
        RationalNumber rationalNumber  = new RationalNumber(1,2) ;
        RationalNumber rationalNumber2  = new RationalNumber(3,4) ;
        System.out.println(rationalNumber.getNumerator());
        System.out.println(rationalNumber.getDenominator());
        System.out.println(rationalNumber.toString());
        System.out.println(rationalNumber2.toString());
        System.out.println(rationalNumber.divide(rationalNumber2));
        System.out.println(rationalNumber.add(rationalNumber2));
        System.out.println(rationalNumber2.multiply(rationalNumber));
        System.out.println(rationalNumber.subtract(rationalNumber2));
    }
}
