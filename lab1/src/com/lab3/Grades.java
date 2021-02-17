package com.lab3;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many test did you take");
        int test = in.nextInt();
        int i =1;
        double totalPercentage =0;
        double grade =0;
        do {
            System.out.println("Enter quiz" +  i  +  "grade and weight");
            double readGrade = in.nextDouble();
             double percentage = in.nextDouble();
             totalPercentage+= percentage;
             grade+=percentage*readGrade;
                    i+=1;
        }while(i<=test);
    if (Math.abs(totalPercentage-1)>0.05){
        System.out.print("The total percentage does not meet requirement");
        return;
    }
        System.out.print(" Jake's grade is:"+grade);
    }
}
