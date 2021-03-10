package com.Lab6;

public class Marketer extends Employee{

    public Marketer() {
        this.setBaseSalary(super.getSalary() +10000);
    }

    public void advertise(){
        System.out.println("Act now while supplies last!");
    }

}
