package com.Lab5;

public class Complex {
     private double real;
     private double imaginary;
     public Complex(double real, double imaginary){
         this.imaginary = imaginary;
         this.real = real;
     }
     public double getReal() {return this.real;}
     public double getImaginary() {return this.imaginary;}
     public Complex add(Complex complex){ return new Complex(this.real+complex.real, this.imaginary+complex.imaginary); }
     public Complex subtract(Complex complex){ return new Complex(this.real-complex.real, this.imaginary-complex.imaginary); }
     public Complex product(Complex complex){ return new Complex(this.real*complex.real, this.imaginary*complex.imaginary); }
     public Complex conjugate(){ return new Complex(this.real, this.imaginary*(-1)); }
     public Complex divide(Complex complex){ return new Complex(this.real/complex.real, this.imaginary/complex.imaginary); }
     public double norm(){ return (Math.abs(Math.sqrt(Math.pow(this.real,2)+(Math.pow(this.imaginary,2))))); }
     public String toString(){ return  new String((int) (this.real) +" + "+(int)this.imaginary)+"i";}


    public static void main(String[] args) {
        Complex first = new Complex(1,2);
        Complex second = new Complex(3,4);
        first   =first.add(second);
        first = first.product(second);
        first = first.subtract(second);
        second.norm();
        second.conjugate();
        second.divide(first);
        System.out.println(second.conjugate().toString());
        System.out.println(second.getImaginary());
        System.out.println(second.getReal());
        System.out.println(first.getReal());
        System.out.println(first.imaginary);
        System.out.println(first.toString());
    }
}
