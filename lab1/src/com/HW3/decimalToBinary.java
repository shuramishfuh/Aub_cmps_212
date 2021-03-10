package com.HW3;

public class decimalToBinary {

    public static void main(String[] args) {
        int n = 605;
        int[] result =decToBinary(n);
        for (int x : result){
            System.out.print(x);
        }

    }
    static int[] decToBinary(int n)
    {
        int[] binaryNum = new int[32];

        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        int[] out = new int[i];
        int count =0;
        // printing binary array in reverse order
        for (int j = i - 1; j >= 0; j--) {
            out[count] = binaryNum[j];
            count++;
        }
        return out;
    }
}
