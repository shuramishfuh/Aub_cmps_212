package com.Hw6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PracticingArrayLists {
    public static ArrayList intersect(ArrayList list ,ArrayList list1) {
        ArrayList arrayList = new ArrayList();
        for (Object x : list) {
                if(list1.contains(x)){
                    if(!arrayList.contains(x)) {
                        arrayList.add(x);
                    }
                }
        }
        return arrayList;
    }
    public static ArrayList reverse(ArrayList list) {
        ArrayList arrayList = new ArrayList();
        for (int i = list.size()-1; i >=0 ; i--) {
            arrayList.add(list.get(i));
        }
        return arrayList;
    }
    public static ArrayList capitalizePlurals(ArrayList list ){

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).toString().endsWith("s")){
                list.set(i,list.get(i).toString().toUpperCase());
            }
        }
        return list;
    }
    public static ArrayList removePlurals (ArrayList list ){

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).toString().endsWith("s")){
                list.remove(i);
            }
        }
        return list;
    }
    public static ArrayList sortInPlace(ArrayList arr ){

        ArrayList list =new ArrayList(arr);
        int smallestIndex;
        int smallest;
        for (int curIndex = 0; curIndex < list.size(); curIndex++) {
            smallest = (int)list.get(curIndex);
            smallestIndex = curIndex;

            for (int i = curIndex + 1; i < list.size(); i++) {
                if (smallest >(int) list.get(i)) {
                    smallest = (int)list.get(i);
                    smallestIndex = i;
                }
            }
            if (smallestIndex == curIndex)
                ;
            else {
                int temp = (int)list.get(curIndex);
                list.set(curIndex, (int)list.get(smallestIndex));
                list.set(smallestIndex, temp);
            }
        }
        return list;
    }
    public static ArrayList SortModify(ArrayList list ){
        int smallestIndex;
        int smallest;
        for (int curIndex = 0; curIndex < list.size(); curIndex++) {
            smallest = (int)list.get(curIndex);
            smallestIndex = curIndex;

            for (int i = curIndex + 1; i < list.size(); i++) {
                if (smallest >(int) list.get(i)) {
                    smallest = (int)list.get(i);
                    smallestIndex = i;
                }
            }
            if (smallestIndex == curIndex)
                ;
            else {
                int temp = (int)list.get(curIndex);
                list.set(curIndex, (int)list.get(smallestIndex));
                list.set(smallestIndex, temp);
            }
        }
        return list;
    }





    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(Arrays.asList(2,12,23,3,4,5,6,7));
        ArrayList arr1 = new ArrayList(Arrays.asList(12,2,3,54,54,62,7));
        ArrayList arrayList1 = new ArrayList(Arrays.asList("this","cool","a","bis"));
//        System.out.println(intersect(arrayList,arr1));
//        System.out.println(reverse(arrayList));
//        System.out.println(capitalizePlurals(arrayList1));
//        System.out.println(removePlurals(arrayList1));
//        System.out.println(sortInPlace(arrayList));
        System.out.println((arrayList));
        System.out.println(SortModify(arrayList));
        System.out.println((arrayList));

    }
}
