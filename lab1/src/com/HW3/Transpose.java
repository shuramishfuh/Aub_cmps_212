package com.HW3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Transpose {



    public static int[][] readArray(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int rows = 4;
        int columns = 4;
        int [][] arr = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<arr.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        return arr;
    }

    public static void printArray(int[][] arr){
    int m = arr.length;
    int n = arr[0].length;
    for(int x = 0; x < n; x++) {
        for(int y = 0; y < m; y++) {
            System.out.print(arr[y][x]);
        }
        System.out.println("");
    }
}

    public static int[][] transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposedMatrix = new int[n][m];

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                transposedMatrix[x][y] = matrix[y][x];
            }
        }

        return transposedMatrix;
    }
}
