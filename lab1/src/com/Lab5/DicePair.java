package com.Lab5;

public class DicePair {
    private Die die1 =new Die();
    private Die die2 =new Die();
    public DicePair(Die die1, Die die2){ this.die1 =die1; this.die2=die2;}
    public int roll(){ return this.die1.roll()+ this.die2.roll();}
}
