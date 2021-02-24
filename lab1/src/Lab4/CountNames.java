package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountNames {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner a = read("output_ex1.txt");
        mostCommonNames(a);
    }

    public static void mostCommonNames(Scanner scan) {
            while(scan.hasNextLine()) {
                Scanner line = new Scanner(scan.nextLine());

                List<String> str = new ArrayList<>();
                while (line.hasNext()){
                    str.add(line.next());
                }
                String word = null;
                int count = 0;
                for(String s: str){
                    int d =Collections.frequency(str,s);
                  if(  d>count){
                      word =s;
                      count=d;
                  }
                }
                if(word != null) {
                    System.out.println("Most common "  +word);
                }

            }
    }

    public static Scanner read(String fileName) throws FileNotFoundException {
        File myObj = new File(fileName);
        return new Scanner(myObj);
    }
}
