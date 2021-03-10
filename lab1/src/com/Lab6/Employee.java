package com.Lab6;

public class Employee {
   private int baseHours = 40;
   private double baseSalary = 40000.0;
   private int baseVacationDays = 10;
   private String baseVacationForm = "yellow";

   public   int getHours(){return this.baseHours;}
   public double getSalary(){return this.baseSalary;}
   public int getVacationDays(){return this.baseVacationDays;}
   public String getVacationForm(){return this.baseVacationForm;}

   public void setBaseHours(int hours){this.baseHours =hours;}
   public void setBaseSalary(double salary){this.baseSalary =salary;}
   public void setBaseVacationDays(int days){this.baseVacationDays =days;}
   public void setBaseVacationForm(String form){this.baseVacationForm =form;}


}
