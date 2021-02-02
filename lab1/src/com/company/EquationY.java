package com.company;
import java.lang.Math;
public class EquationY {
    public static void main(String[] args) {
        double x = 5;
        double y = 12.5*Math.pow(x,4)-9.1*Math.pow(x,3)+
                19.3*Math.pow(x,2)-4.6*x  + 34.2;
        System.out.println("y is  " + y);
    }
}
