package com.Lab5;

public class Die {
    private  int rand;
    public Die(){ }
    public int roll(){ return  (int)(Math.random() * (6 - 1) + 1) + 1; }
}
