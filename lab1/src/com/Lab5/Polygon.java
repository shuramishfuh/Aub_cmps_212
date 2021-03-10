package com.Lab5;

public class Polygon {
    int sides;
    int length;
    public Polygon(int sides, int length){ this.length =  length; this.sides=sides; }
    public double perimeter(){return sides*length;}
    public double area(){ if (sides == 0) { System.out.println("error divide by zero"); return 0;}
    return (length*length*sides)/(4*Math.tan(Math.PI/sides));
    }

}
