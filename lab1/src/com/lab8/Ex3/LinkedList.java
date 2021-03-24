package com.lab8.Ex3;

class LinkedList<T>{
public Node<T> head = null;
public Node<T> tail = null;

    public void addNode(T data) {
        Node<T> newNode = new Node<T>(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public int getLength(){
        int c=0;
        for(Node<T>itr=head;itr!=null;itr=itr.next)c++;
        return c;
    }

    public void swap(T n1, T n2){
        //...
        if (n1 == n2) {
            System.out.println("same Values ");
            return;
        }
        boolean found1 = false, found2 = false;
        Node node = head;
        while (node != null && !(found1 && found2)) {
            if (node.data == n1) {
                node.data = n2;
                found1 = true;
                node = node.next;
                continue;
            }
            if (node.data == n2) {
                node.data = n1;
                found2 = true;
                node = node.next;
                continue;
            }
            node = node.next;
        }
    if (!(found1 && found2)) {
            System.out.println("Values not found");
        }
    }

    public void resize(int capacity){
        //...
        Node pre = null;
        if(this.getLength() != capacity){
            if (this.getLength() < capacity){
                while (this.getLength() != capacity){
                   this.addNode(null);
                }
            }

            else {
                Node node = head;
                while (this.getLength() != capacity) {
                    while (node.next != null) {
                        pre = node;
                        node = node.next;
                        this.tail = null;
                    }
                    tail=pre;
                    pre.next = null;
                }
            }
        }
    }
}