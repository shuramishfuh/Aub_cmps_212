package com.lab2;

public class bday {
    public static void main(String[] args) {
        System.out.printf( get(9,19,"Suszy",6,14));
    }
    public static String get(int ybm,int db,String npsnt,int npbm,int npbd){
        return "My birthday is "+ ybm+"/"+(db) +" and "+ npsnt+"'s is "+npbm+"/"+npbd+".";
    }
}
