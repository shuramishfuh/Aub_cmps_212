package com.HW3;

public class MyArrays {

    public static int linearSearch(int[] arr, int key, int start, int end) {

            int count = 0;
            for (int i = start; i < end; i++) {
                if (arr[i] != key) count++;
                else return count;
            }
            return -1;
    }

    public static Boolean equals(int[] first, int[] second){
        if (first.length != second.length) return false;
        else if((first.length == 0 && second.length !=0)||(second.length ==0 && first.length!=0)) return false;
        else {
            for (int i = 0; i <first.length ; i++) {
                    if (first[i] != second[i]) return false;
            }
        }
        return true;
    }

    public static void  fill(int[] arr, int value, int start, int end){
        if(arr.length == 0) return;
        else{
            for (int i = start; i <end ; i++) {
                arr[i] =value;
            }
        }
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

    public static void sort(int[] arr, int start, int end){
        for (int i = start; i <end ; i++) {
            for (int j = start; j <end ; j++) {
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] copyOf(int[] arr, int start, int end){
        if (start > end) return new int[0];
        int  size = end-start;
        int[] temp = new int[size];
        int counter =0;
        for (int i = start; i <end ; i++) {
                temp[counter] =arr[i];
                counter++;
        }
        return temp;
    }
}
