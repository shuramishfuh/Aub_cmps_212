package com.HW4;

public class RationalNumber {
    private int numerator;
    private int denominator;
    public RationalNumber(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator ==0) {throw new IllegalArgumentException();}
        this.denominator = denominator;
        reduce();
    }
    public RationalNumber(){this.numerator=0; this.denominator=1; reduce();}
    public int getDenominator(){return this.denominator;}
    public int getNumerator(){return this.numerator;}
    public String toString() {
        if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        } else {
            return (this.numerator + "/" + this.denominator);
        }
    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public  void reduce() {
        if (this.denominator < 0) {
            this.denominator *= -1;
            this.numerator *= -1;
        }
        // store sign
        int sign =this.numerator >0?1:-1;
        this.numerator=Math.abs(this.numerator);
        this.denominator=Math.abs(this.denominator);
        int lesser = this.numerator < this.denominator ? this.numerator : this.denominator;
        int gcm = gcd(this.numerator, this.denominator);
            if (lesser >= gcm) { this.numerator /= gcm;this.denominator /= gcm;}
        this.numerator *=sign;
        }
    public  RationalNumber add(RationalNumber number) {
        int denominator = this.denominator * number.denominator;
        int numerator = this.numerator * number.denominator +
                number.numerator * this.denominator;
        return new RationalNumber(numerator,denominator);
    }
    public  RationalNumber subtract(RationalNumber number) {
        int resultDenominator = this.denominator * number.denominator;
        int resultNumerator = this.numerator * number.denominator -
                number.numerator * this.denominator;

        return new RationalNumber( resultNumerator, resultDenominator );
    }
    public RationalNumber multiply(RationalNumber number){
        return new RationalNumber( numerator * number.numerator, denominator * number.denominator );
    }
    public RationalNumber divide(RationalNumber number){
        return new RationalNumber( numerator * number.denominator, denominator * number.numerator );
    }

}
