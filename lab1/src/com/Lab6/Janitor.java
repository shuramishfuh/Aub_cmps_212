package com.Lab6;

public class Janitor extends Employee {
    public  Janitor(){
        this.setBaseSalary(super.getSalary() -10000);
        this.setBaseHours(2*super.getHours());
        this.setBaseVacationDays(super.getVacationDays()/2);
    }

    public void clean(){
        System.out.println(" Working for the man");
    }
}
