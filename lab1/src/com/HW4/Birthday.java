package com.HW4;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("what month, day and year were you born?");
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int year = scanner.nextInt();
        TeacherDate teacherDate = new TeacherDate(year,month,day);
        TeacherDate today = new TeacherDate();
        System.out.println("You were born on "+teacherDate.toString() + " which was a " + teacherDate.getDayOfWeek());
        if ((teacherDate.isLeapYear())) { System.out.println(teacherDate.getYear() + " was a leap year"); }
        if (teacherDate.getMonth() ==today.getMonth() && teacherDate.getDay() == today.getDay()){
            System.out.println("Happy birthday! you are now "+ (today.getYear()-teacherDate.getYear()));System.out.println("you are " +getTotalDays(teacherDate,today)+" days old"); }
        else  {
            //greater month
            if (teacherDate.getMonth()> today.getMonth()){
                TeacherDate temp = new TeacherDate(today.getYear(),today.getMonth(),today.getDay());
                int days=0;
                while (!testForEqualDaysAndMonth(teacherDate,today)){
                    today.nextDay();
                    days++;
                }
                System.out.println("It will be your birthday in "+days +" days");
                System.out.println("you are " +getTotalDays(teacherDate,temp)+" days old");
            }
            // same month but different days
            else if(teacherDate.getMonth() == today.getMonth()) {
                // day is less than
                int days =0;
                if (teacherDate.getDay() < today.getDay()){
                    TeacherDate temp = new TeacherDate(teacherDate.getYear(), teacherDate.getMonth(), teacherDate.getDay());
                    while (teacherDate.getDay() != today.getDay()){
                        teacherDate.nextDay();
                        days++;
                    }
                    System.out.println("It will be your birthday in "+days +" days");
                    System.out.println(" you are " +getTotalDays(temp,today)+" days old");
                }
                else {
                    // days greater
                    TeacherDate temp = new TeacherDate(today.getYear(),today.getMonth(), today.getDay());
                    while (teacherDate.getDay() != today.getDay()){
                        today.nextDay();
                        days++;
                    }
                    System.out.println("It will be your birthday in "+days +" days");
                    System.out.println(" you are " +getTotalDays(teacherDate,temp)+" days old");
                }
            }
            // less month
            else {
                TeacherDate temp = new TeacherDate(teacherDate.getYear(),teacherDate.getMonth(),teacherDate.getDay());
                int days =0;
                while (!testForEqualDaysAndMonth(today,teacherDate)){
                    teacherDate.nextDay();
                    days++;
                }
                System.out.println("It will be your birthday in "+days +" days");
                System.out.println("you are " +getTotalDays(temp,today)+" days old");
            }
        }
    }

    private static int getTotalDays (TeacherDate userDate, TeacherDate today){
        int daysCount =0;
        while (!userDate.equals(today)){
            userDate.nextDay();
            daysCount++;
        }
        return daysCount;
    }
    private static boolean testForEqualDaysAndMonth (TeacherDate userDate, TeacherDate today){
        return ((userDate.getMonth() ==today.getMonth()) && (userDate.getDay() ==today.getDay()))?true:false;
    }
}
