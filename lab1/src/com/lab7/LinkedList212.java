package com.lab7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedList212 extends LinkedList {
    public void  sortList( LinkedList list){
        Collections.sort(list);
    }
    /* cant find a way to call the inbuilt construction or
    representation or the LinkedList to avoid passing list as parameter
@param list  is to refer to the this object
     */
    public void printDuplicates(LinkedList list){
        for (int i = 0; i <list.size() ; i++) {
            for (int j = i+1; j <list.size() ; j++) {
                if(list.get(i)  == list.get(j)){
                    System.out.println(list.get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList212 arr1 = new LinkedList212();
        arr1.add(4);
        arr1.add(1);
        arr1.add(0);
        arr1.add(0);
        arr1.add(3);
        arr1.add(3);

//        arr1.printDuplicates(arr1);
        System.out.println(arr1);
        arr1.sortList(arr1);
        System.out.println(arr1);
    }

}
