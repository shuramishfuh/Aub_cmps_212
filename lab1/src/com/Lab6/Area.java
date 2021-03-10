package com.Lab6;

public class Area extends Shape {

    @Override
    public void RectangleArea(double len, double wi) {
        System.out.println( len*wi);
    }

    @Override
    public void SquareArea(double len) {
        System.out.println( 4*len);
    }

    @Override
    public void CircleArea(double len) {
        System.out.println(Math.PI*(len*len));
    }

    public static void main(String[] args) {
       Area area = new Area() ;
       // squares
        for (int i = 1; i <6 ; i++) {
            area.SquareArea(i);
        }
        // rect
        int j=1;
        for (int i = 1; i <6 ; i++) {
            area.RectangleArea(i,j);
            j++;
        }
        // circle
        for (int i = 1; i <6 ; i++) {
            area.CircleArea(i);
        }
    }
}
