package com.Lab5;

public class Triangle  extends Polygon{
     public Triangle(int length){
         super(3,length);
     }

    @Override
    public double area() {
        return .5*(sides*length);
    }
}
