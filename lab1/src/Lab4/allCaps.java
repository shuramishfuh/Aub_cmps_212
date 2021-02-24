package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class allCaps {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println((READ()));

    }



    public static List<String> READ() {
        List<String> result = new ArrayList<>();
        try {
            File myObj = new File("src/Lab4/input.txt");
            Scanner scan = new Scanner(myObj);

            while (scan.hasNextLine()) {
                result.add(scan.next().toUpperCase(Locale.ROOT));
            }
            File file = new File("output_ex1.txt");
             PrintStream out = new PrintStream(file);
             StringBuilder write = new StringBuilder();
            for (String x:result) {
                write.append(" " +x);
            }
             out.print(write);

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
            return  result;
    }
}
