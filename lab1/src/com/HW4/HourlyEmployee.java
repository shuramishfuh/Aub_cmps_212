package com.HW4;

public class HourlyEmployee extends Employee{
    private double wage;

    private double hours;

    public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hour) {
        super(firstName, lastName, ssn);
        this.wage = wage;
        this.hours =hour;
    }

    public void setWage(double wage) {
        if (wage < 0) {
            this.wage = 0;
        } else {
            this.wage = wage;
        }
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if (hours < 168 && hours>0) {
            this.hours = hours;
        } else {
            this.hours = 0;
        }
    }

    @Override
    public double earnings() {
        return (hours<40)?(this.hours*this.wage):((40*this.wage) +( (this.hours-40)*this.wage*1.5) );
    }

    @Override
    public String toString() {
        return "salaried employee :" + super.getFirstName() + "\t" + super.getLastName() +
                "\n" + "social security number : " + super.getsSN() + "\n"
                + "Hourly wage: " + this.wage + ";" + " hours worked: " + this.hours;
    }


}
