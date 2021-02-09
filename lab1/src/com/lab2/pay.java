package com.lab2;

public class pay {
    public static void main(String[] args) {
        System.out.print(pay(4.0,11));
    }
    public static double pay(double rate, int hrs){
        if(hrs>8) return ((8*rate) +((rate*1.5)*(hrs-8)));
        else return hrs*rate;
    }
}
