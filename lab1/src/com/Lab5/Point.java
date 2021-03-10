package com.Lab5;

public class Point {
    int x;
    int y;
    public Point(int x,int y){ this.y = y; this.x = x;
    }
    public Point(Point point){this.x =point.x; this.y =point.y;}
    public static double distance(Point first, Point second){ return   Math.sqrt (Math.pow(first.y-second.y,2)+Math.pow(first.x-second.x,2)); }
    public String toString(){return "(" + this.x + " " + this.y + ")";}
    public static Boolean isCollinear(Point first, Point second){
        if(first.x -second.x == 0){ System.out.println("error divide by zero"); return false; }
        return Math.abs((first.y - second.y) / (first.x - second.x)) == 1;
    }

    public static void main(String[] args) {
        Point a =new Point(2,4);
        Point b = new Point(a);
        System.out.println(Point.distance(a,b));
        System.out.println(b.toString());
        System.out.println(Point.isCollinear(a,b));
    }
}
