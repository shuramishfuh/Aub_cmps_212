package com.Hw6;

import java.util.Arrays;

public class MyArrays {
    public static int  linearSearch (int[] arr, int key, int start, int end){
        for (int i = start; i <end ; i++) {
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static boolean equals(int[] a, int[] b){
        if( (a == null  && b !=null) || (a != null  && b ==null) ) { return  false; }
        else if( (a == null  && b ==null)  ) { return  true; }
        else if(a.length != b.length){return false;}
        else   {
            for (int i = 0; i <a.length ; i++) {
                if (a[i] != b[i]){ return  false; }
            }
        }
        return true;
    }

    public static void fill(int[] arr, int value, int start, int end ) throws Exception {
        if(start>arr.length || end> arr.length
        || start>end || start <0 || end <0 || arr== null){
            throw new Exception("invalid input");
        }
        else {
            for (int i = start; i <end ; i++) {
                arr[i] =value;
            }
        }
    }

    public static int[] copyOf(int[] arr , int start, int end) throws Exception {
        int[] a = new int[end-start];
        if(start>arr.length || end> arr.length
                || start>end || start <0 || end <0 || arr== null){
            throw new Exception("invalid input");
        }
        else {
            int count =0;
            for (int i = start; i < end; i++) {
                a[count]= arr[i];
                count++;
            }
        }
        return a;
    }

    public static String toString(int[] arr){
        StringBuilder result =new StringBuilder();
        result.append("\"");
        result.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i ==(arr.length-1)) {
                result.append(arr[i]);
            }

            else
                result.append(arr[i]).append(",").append(" ");
        }
        result.append("]");
        result.append("\"");
        return result.toString();
    }

    public static void sort(int[] array, int start, int end) throws Exception {
        int[] arr = copyOf(array,start,end);
        int n =arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        int count =0;
        for (int i = start; i <end ; i++) {
            array[i] =arr[count];
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
       int[] a = {1,23,3,43,5,61,7,8,9};
       int[] b = {1,23,3,43,5,61,7,8,9};
       int[] c = {1,23,3,43,5,61,7,86,9};
//        System.out.println(MyArrays.linearSearch(a,5,2,5));
//        System.out.println(MyArrays.linearSearch(a,5,2,2));
//        System.out.println(MyArrays.equals(a,c));
//        System.out.println( Arrays.toString(a));
//        MyArrays.fill(a,12,0,3);
//        System.out.println( Arrays.toString(a));
//        System.out.println(Arrays.toString(MyArrays.copyOf(a,2,5)));
//        System.out.println(MyArrays.toString(a));
//        MyArrays.sort(a,0,4);
//        System.out.println(MyArrays.toString(a));
    }

}
