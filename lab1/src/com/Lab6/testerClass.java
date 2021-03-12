package com.Lab6;

import java.util.Scanner;

public class testerClass {
    public static void print(){
        System.out.println(" what shape would you like to input");
        System.out.println("1 : square");
        System.out.println("2 : rectangle");
        System.out.println("3 : Circle");
    }
    public static void main(String[] args) {
        Shape circle = new Circle(3);
        Shape rect = new Rectangle(2,4);
        Shape square = new Square(5);

        System.out.println(rect.getArea());
        System.out.println(square.getArea());
        System.out.println(circle.getArea());
        Shape[] shapes = new Shape[5];
        int count =5;
        int insideCount =0;
        Scanner scanner = new Scanner(System.in);
        while(count>0){
            print();
            while( true) {
                int num = scanner.nextInt();

                        if (num == 1) {
                            System.out.println("enter len");
                            shapes[insideCount] = new Square(scanner.nextInt());
                            insideCount++;
                            count--;
                            break;
                        }
                        else if (num == 2) {
                            System.out.println("enter len and width");
                            shapes[insideCount] = new Rectangle(scanner.nextInt(), scanner.nextInt());
                            insideCount++;
                            count--;
                            break;
                        }
                       else if (num == 3) {
                            System.out.println("enter rad");
                            shapes[insideCount] = new Circle(scanner.nextInt());
                            insideCount++;
                            count--;
                            break;
                        }

                       else {System.out.println("input invalid");}
                }
        }

        for (Shape x :shapes) {
            System.out.println(x.getClass().getName());
            System.out.println("area is " + x.getArea());
        }


    }
}
