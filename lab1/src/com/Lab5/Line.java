package com.Lab5;

public class Line {
    Point first;
    Point second;
    public Line(Point first, Point second){ this.first =first;this.second =second; }
    public Line(int x1, int y1, int x2, int y2){ this.first = new Point(x1,y1);this.second = new Point(x2,y2); }
    public Point getFirstPoint(){return this.first;}
    public Point getSecondPoint(){return this.second;}
    public double slope (){
        if(first.x- second.x ==0){ System.out.println("error divide by zero"); return 0;}
      return   (first.y - second.y)/(first.x- second.x);
    }
    public  boolean isCollinear(Point in){
        if (Point.isCollinear(this.first,in)) {return true;}
        else if(Point.isCollinear(this.second,in)){return true;}
        else  {return false;}
    }

    public String toString(){
        return ("["+"("+this.first.x+", " +this.first.y+")" +","+ "("+this.second.x+", " +this.second.y+")"+"]");
    }

    public static void main(String[] args) {
        Point a = new Point(2,4);
        Line b = new Line(4,6,6,8);
        System.out.println(b.getFirstPoint());
        System.out.println(b.getSecondPoint());
        System.out.println(b.isCollinear(a));
        System.out.println(b.toString());
    }
}
