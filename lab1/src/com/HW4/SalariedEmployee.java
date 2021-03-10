package com.HW4;

public class SalariedEmployee extends Employee{
    private  double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary ) {
        super(firstName, lastName, ssn);
        this.weeklySalary =weeklySalary ;
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0) {
            this.weeklySalary = 0;
        } else {
            this.weeklySalary = weeklySalary;
        }
    }


    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return "salaried employee :" + super.getFirstName() + "\t" + super.getLastName() +
                "\n" + " social security number : " + super.getsSN() + "\n" + " weekly salary : " + this.earnings();
    }

}
