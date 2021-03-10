package com.Lab5;

public class Square extends Polygon {

    public Square(int length) {
        super(4, length);
    }

    @Override
    public double area() {
        return sides*length;
    }
}
