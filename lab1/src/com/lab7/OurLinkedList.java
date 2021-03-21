package com.lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Predicate;

public class OurLinkedList {
    public static void deleteAll(LinkedList list , int key){
        LinkedList a = new LinkedList();
       list.forEach(n->{
           if((int)n !=key){
               a.add(n);
           }
       });
       list.clear();
        list.addAll(a);
    }
    public static ArrayList indexesOf(LinkedList list, int key){
        ArrayList arrayList = new ArrayList() ;
        int y=0;
        for ( Object x: list) {
            if ((int)x == key){ arrayList.add(y);}
            y++;
        }
        return arrayList;
    }
    public static LinkedList revrese(LinkedList list ){
        LinkedList linkedList = new LinkedList();
        for (int i = list.size()-1; i >=0 ; i--) { linkedList.add(list.get(i)); }
        return linkedList;
    }
    public static LinkedList join(LinkedList list1, LinkedList list ){
        list1.forEach(n->{ list.add(n); });
        Collections.sort(list);
        return list;
    }
    public  static  LinkedList intersection(LinkedList list , LinkedList list1){
        LinkedList linkedList = new LinkedList() ;
        for (int i = 0; i < list.size() ; i++) {
            for (int j = 0; j < list1.size() ; j++) {
                if ((int) list.get(i) == (int)list1.get(j)){
                    linkedList.add(list.get(i));
                }
            }
        }
        return linkedList;
    }
    public static LinkedList union(LinkedList list , LinkedList list1){
        return join(list,list1);

    }
    public static LinkedList markLengthUpdated(LinkedList list , int i){
        for (int j = 0; j <list.size() ; j++) {
            String s =(String) list.get(j);
            if(s.length() == i){
                list.set(j,"***");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(7);
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(7);
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(16);
        list1.add(19);
        list1.add(0);
        list1.add(3);

        LinkedList<String> lists = new LinkedList<>();
        lists.add("to");
        lists.add("be");
        lists.add("cool");
//        deleteAll(list,7);
//        System.out.println(indexesOf(list,7));
//        System.out.println(revrese(lists));
//        System.out.println(join(list,list1));
//        System.out.println(intersection(list,list1));
//        System.out.println(union(list,list1));
//        System.out.println(markLengthUpdated(lists,3));
    }
}
