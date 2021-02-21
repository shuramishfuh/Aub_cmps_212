package com.HW2;

public class Series {
    public static void main(String[] args) {

        int count = 0;
        double sum = 0;
        while(sum != 2.0){
            count++;
            sum = computeSum(count);
            System.out.println("Smallest value : " + count);
        }
    }
    public static double computeSum(int n){

        double sum = 0;
        for(int i = 0; i < n; i++)
            sum += Math.pow(0.5, i);
        return sum;
    }
}
