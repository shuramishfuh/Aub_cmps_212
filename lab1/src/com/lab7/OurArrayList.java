package com.lab7;

import java.util.ArrayList;
import java.util.Collection;

public class OurArrayList {
    public static void scaleByK(ArrayList arr) {
            int i = 0;

            while(i < arr.size())
            {
                int value = (int)arr.get(i);

                if(value > 0)
                {
                    for(int j = 1; j < value; j++)
                    {
                        arr.add(i + j, value);
                    }

                    i += value;
                }
                else
                {
                    arr.remove(i);
                }
            }
        }
    public static void removeDuplicates(ArrayList<String> arr){
        String elemnt;
        int count =0;
        for (int i = 0; i <arr.size() ; i++) {
            elemnt = arr.get(i);
            for (int j = i; j <arr.size() ; j++) {
                if (arr.get(j) == elemnt){
                    arr.remove(elemnt);
                }
            }
        }
    }
    public static void removeInRange(ArrayList<String> arr,String start, String end){
        ArrayList a = new ArrayList();
        for (String x:arr) {
            if( x.compareToIgnoreCase(start)>=0  && end.compareToIgnoreCase(x)>=0){
              continue;
            }
            else {
                a.add(x);
            }
        }
        arr.clear();
        arr.addAll(a);


    }
    public static void markLength4(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() == 4) {
                arr.add(i, "****");
                i++;
            }

        }
    }

        public static void main (String[]args){
            ArrayList arr = new ArrayList();
            ArrayList arr1 = new ArrayList();

            arr1.add(4);
            arr1.add(1);
            arr1.add(0);
            arr1.add(3);
            arr.add("bhe");
            arr.add("zo");
            arr.add("toot");
            arr.add("toot");
            arr.add("toot");
            arr.add("yoy");
            arr.add("yoy");
            arr.add("yoy");

            scaleByK(arr1);
            System.out.println(arr1);
            removeDuplicates(arr);
            markLength4(arr);
            System.out.println(arr);
        }
}
