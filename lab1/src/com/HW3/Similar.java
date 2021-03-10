package com.HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Similar {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("enter first filename");
        String first = in.next();
        System.out.println("enter second filename");
        String second = in.next();
        System.out.println(isSimilar(read(first),read(second)));
    }

    public static Scanner read(String fileName) throws FileNotFoundException {
        return new Scanner(new File( fileName));
    }

    public static  Boolean isSimilar(Scanner one ,Scanner two){
        List first = new ArrayList();
        List second = new ArrayList();
        while (one.hasNextLine() && two.hasNextLine()){
            first.add(one.nextLine());
            second.add(two.nextLine());
        }
        // if length are not the same the files cannot be the same
        if (first.equals(second))return true;
        else    return false;
    }
}
