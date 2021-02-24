package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Duplicates {
    public static void main(String[] args) throws FileNotFoundException {
       Scanner a = read("output_ex1.txt");
       printDuplicates(a);

    }


    public static void printDuplicates(Scanner scan) {
        while(scan.hasNextLine()) {
            Scanner line = new Scanner(scan.nextLine());
            String current = "";
            int count = 0;

            while(line.hasNext()) {
                String next = line.next();
                if(next.equals(current)) {
                    count++;
                } else {
                    if(count > 1)
                        System.out.print(current + "*" + count + " ");
                    current = next;
                    count = 1;
                }
            }

            if(count > 1)
                System.out.print(current + "*" + count);

            System.out.println();
        }
    }
    public static Scanner read(String fileName) throws FileNotFoundException {
        File myObj = new File(fileName);
        return new Scanner(myObj);
    }
}
