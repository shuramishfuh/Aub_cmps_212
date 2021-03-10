package com.Lab6;

public class HarvardLawyer  extends Lawyer{

    public HarvardLawyer() {
        this.setBaseSalary((super.getSalary()+ (super.getSalary()*.2)));
        this.setBaseVacationDays(super.getVacationDays()+3);
    }

    @Override
    public String getVacationForm() {
        return super.getVacationForm() +super.getVacationForm()+super.getVacationForm()+super.getVacationForm();
    }

}
