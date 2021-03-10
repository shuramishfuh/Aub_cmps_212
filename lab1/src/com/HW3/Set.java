package com.HW3;

import java.util.Arrays;

public class Set {

    public static void main(String[] args) {
        boolean[] a = createSet("0124567");
        boolean[] b = createSet("123567");
        System.out.println(cardinality(a));
        System.out.println(toString(a));
        addElement(a,3);
        System.out.println(toString(a));
        System.out.println(equals(a,b));
        System.out.println(toString(union(a,b)));
        System.out.println(toString(intersect(a,b)));
        System.out.println(toString(intersect(a,b)));
    }

    public static boolean[] createSet(String str){
        boolean[] arr = new boolean[10];
        Arrays.fill(arr,false);
        for (Character x: str.toCharArray()
             ) {
            arr[Integer.valueOf(String.valueOf(x))] =true;
        }
        return arr;
    }

    public static int cardinality(boolean[] set){
        int counter =0;
        for (boolean x: set
             ) {
            if (x ==true) counter++;
        }
        return counter;
    }

    public static boolean inSet(boolean[] set, int value){
      return   (set[value]==true)? true:false;
    }

    public static void addElement(boolean[] set, int value){
        set[value] = true;
    }

    public static boolean equals(boolean[] set1, boolean[] set2){
        for (int i = 0; i <set1.length ; i++) {
            if(set1[i] != set2[i]) return false;
        }
        return true;
    }

    public static boolean[] union(boolean[] set1, boolean[] set2){
        for (int i = 0; i <set1.length ; i++) {
            if(set2[i] == true){
                set1[i] =true;
            }
        }
        return set1;
    }

    public static boolean[] intersect(boolean[] set1, boolean[] set2) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < set1.length; i++) {
            if (set1[i] == set2[i] && set1[i] != false) {
                str.append(i);
            }
        }
        return createSet(str.toString());
    }

    public static String toString(boolean[] set){
        StringBuilder result =new StringBuilder();
        result.append("\"");
        result.append("{");
        for (int i = 0; i < set.length; i++) {
                if(set[i] ==true) result.append(i +"," +" ");
        }
        result.delete(result.length()-1,result.length());
        result.delete(result.length()-1,result.length());
        result.append("}");
        result.append("\"");
        return result.toString();
    }

    public static boolean[] multiUnion(boolean[][] sets){
        boolean[] result = sets[0];
        for (int i = 0; i <sets.length ; i++) {
            result = intersect(result,sets[i]);
        }
        return result;
    }
}

