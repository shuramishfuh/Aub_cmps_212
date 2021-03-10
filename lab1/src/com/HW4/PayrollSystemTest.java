package com.HW4;

public class PayrollSystemTest {
    public static void main(String[] args) {
        SalariedEmployee sE1 =new SalariedEmployee("james","carter","es2341",400);
        SalariedEmployee sE2 =new SalariedEmployee("john","Doe","3456tg2",500);
        HourlyEmployee hE1 = new HourlyEmployee("harry","kon","1234f",10,43);
        HourlyEmployee hE2 = new HourlyEmployee("kelvin","smart","g3her32",16.75,40);
        System.out.println(sE1+"\n");
        System.out.println(sE2+"\n");
        System.out.println(hE1+"\n");
        System.out.println(hE2+"\n");

        Employee[] arr = {sE1,sE2,hE1,hE2};

        for (Employee x :arr){
            System.out.println(x.toString());
            System.out.println("earned: $" + x.earnings());
            System.out.println();
        }
    }
}
