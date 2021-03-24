package com.lab8.Ex3;

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> l=new LinkedList<>();
        l.addNode(2);
        l.addNode(1);
        l.addNode(4);
        l.addNode(5);

        l.swap(2, 5);


        l.resize(3);
        System.out.println("After resizing, l.length="+l.getLength());

        l.resize(6);
        System.out.println("After resizing, l.length="+l.getLength());
    }
}