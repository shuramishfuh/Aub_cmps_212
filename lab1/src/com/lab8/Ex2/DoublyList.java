package com.lab8.Ex2;

import com.lab8.Ex2.DNode;

import java.util.Collections;

public class DoublyList {
    private DNode header=null;
    private DNode trailer=null;

    public void addFront(int value){
        DNode v = new DNode(value);
        if (header == null)    //check if it is an empty list
            trailer = v;
        else
            header.prev = v;
        v.next = header;
        header = v;
    }

    public void addBack( int value) { // add to back of list
        DNode v = new DNode(value);
        if (trailer == null)    //check if the list is empty
            header = v;
        else
            trailer.next = v;
        v.prev = trailer;
        trailer = v;
    }

    public void printDList(){
        DNode current = header;
        while (current != null){
            System.out.print(current.data);
            if(current.next!=null)
                System.out.print( " <-> ");
            current = current.next;
        }
        System.out.println();
    }

	public void reverse(){
		//...
        DNode current = header;
        if (current.next != null) current= current.next;
            while (current.next != this.trailer && current.next !=null){
                   int temp = current.data;
                   current.data = current.next.data;
                   current.next.data =temp;
                current = current.next;
        }
            int temp  = trailer.data;
            trailer.data = header.data;
            header.data = temp;
	};

	public void remove(int data){
		//...
        DNode current = header;
        boolean done = false;
        while (current.next != null){
            if (current.data == data){
                if (current == header) header=header.next;
                else current.prev.next = current.next;
                done =true;
                break;
            }
            current =current.next;
        }
        if (!done){
        if(current.data == data ) current.prev.next=null;
        }
	};
	public void clean(){
		//...
            DNode ptr1 = null, ptr2 = null, dup = null;
            ptr1 = header;
            while (ptr1 != null && ptr1.next != null) {
                ptr2 = ptr1;
                while (ptr2.next != null) {
                    if (ptr1.data == ptr2.next.data) {
                        dup = ptr2.next;
                        ptr2.next = ptr2.next.next;
                        System.gc();
                    } else {
                        ptr2 = ptr2.next;
                    }
                }
                ptr1 = ptr1.next;
            }
	}

    public void sortList() {
        DNode current = null, index = null;
        int temp;
        //Check whether list is empty
        if(header == null) {
            return;
        }
        else {
            //Current will point to head
            for(current = header; current.next != null; current = current.next) {
                //Index will point to node next to current
                for(index = current.next; index != null; index = index.next) {
                    //If current's data is greater than index's data, swap the data of current and index
                    if(current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }

    public void merge(DoublyList head){
		//...
        DNode current = head.header;
        while (current.next != null){
            DNode v = new DNode(current.data);
            trailer.next = v;
            v.prev = trailer;
            trailer = v;
            current = current.next;
        }
        DNode v = new DNode(current.data);
        trailer.next = v;
        v.prev = trailer;
        trailer = v;
        this.sortList();
        /* it is not possible to keep in sorted order
        first because insertion is not sorted and there is no sorting done
        anywhere else.

        except the user manually ensures its sorted

        so to merge I used one loop as instructed but have to sort since
        the list was not sorted
         */
	}

//    public static void main(String[] args) {
//        DoublyList d = new DoublyList() ;
//        d.addFront(9);
//        d.addFront(3);
//        d.addBack(5);
//        d.addBack(4);
//
//        DoublyList a = new DoublyList() ;
//        a.addFront(1);
//        a.addFront(2);
//        a.addBack(6);
//        a.addBack(7);
//        a.addBack(8);
//
//
//
//        d.printDList();
//        d.reverse();
//        d.printDList();
//        d.reverse();
//        d.remove(3);
//        d.remove(5);
//        d.printDList();
//        d.clean();
//        d.sortList();
//        d.merge(a);
//        d.printDList();
//    }
}