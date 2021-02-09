package com.hwOne;
import java.util.Scanner;

public class qroots {
    public static void main(String[] args) {
       Scanner userIn = new Scanner(System.in);
           System.out.println("enter a");
          double a =userIn.nextDouble();
           System.out.println("enter b");
           double b =userIn.nextDouble();
           System.out.println("enter c");
           double c =userIn.nextDouble();
           double d =(b*b)-(4* c *a );
           if(d<0){
               System.out.println("No real roots");
           }
           else {

            double  ro = (-b + Math.sqrt(d)) / (2 * a);
            double rt = (-b - Math.sqrt(d)) / (2 * a);
               System.out.println("roots are" + " "+ro +" "+ rt);
           }



    }
}
