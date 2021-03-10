package com.HW4;

public class Employee {
    private String firstName;
    private String lastName;
    private String sSN;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName= lastName ;
        this.sSN =ssn ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public double earnings(){return 0;}

    public String toString(){
        return new String(this.firstName +"\t"+ this.lastName + "\n"+"social security number: "+sSN );
    }

}
