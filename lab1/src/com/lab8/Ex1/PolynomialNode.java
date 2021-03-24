package com.lab8.Ex1;

public class PolynomialNode  {
	//...
    int exp, coef;
    PolynomialNode next;
    public PolynomialNode(){ coef =0; exp =0; next = null; }
    public PolynomialNode(int coef, int exp){ this.coef = coef ;this.exp = exp;this.next =null; }
    public PolynomialNode(int coef, int exp,  PolynomialNode next){ this.coef= coef; this.exp=exp; this.next =next; }

}
