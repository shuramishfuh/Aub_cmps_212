package com.Lab6;

public class Lawyer  extends Employee{
    public Lawyer(){
        this.setBaseVacationForm("Pink");
        this.setBaseVacationDays(super.getVacationDays()+5);
    }

    public void sue(){
        System.out.println("I'll see you in court");
    }

}
