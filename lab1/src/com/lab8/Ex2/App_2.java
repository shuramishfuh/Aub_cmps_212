package com.lab8.Ex2;

public class App_2 {

    public static void main(String[] args) {
        DoublyList D1=new DoublyList();
        D1.addFront(1);
        D1.addFront(5);
        D1.addFront(9);
        D1.addFront(5);
        D1.addFront(1);
        D1.addFront(3);
        D1.addFront(3);
        D1.addFront(1);
        D1.addFront(1);
        System.out.println("The list has the following elements:");
        D1.printDList();

        D1.remove(1);
        System.out.println("After reversing the elements are arranged as follow");
        D1.printDList();

        D1.clean();
        System.out.println("When cleaning the D-List, there are no duplicate elements");
        D1.printDList();

        System.out.println("Given the following 2 SORTED D-Lists");
        DoublyList D2=new DoublyList();
        D2.addBack(1); D2.addBack(2); D2.addBack(5); D2.addBack(9); D2.addBack(10); D2.addBack(22);

        DoublyList D3=new DoublyList();
        D3.addBack(3); D3.addBack(5); D3.addBack(6); D3.addBack(11); D3.addBack(20);

        D2.printDList();
        D3.printDList();

        System.out.println("We will merge D3 into D2");
        D2.merge(D3);
        D2.printDList();//1 2 3 5 5 6 9 10 11 20 22
    }
}
