package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class countCharacter {
    public static void main(String[] args) {
    Read();
    }
    public static void Read() {
        int vowels = 0;
        int consonant = 0;
        int punct = 0;

        try {
            File myObj = new File("src/Lab4/input.txt");
            Scanner scan = new Scanner(myObj);

            while (scan.hasNextLine()) {
                char[] temp = scan.next().toCharArray();
                for (char x :
                        temp) {
                    if (x == 'a' || x == 'e' || x == 'i' ||  x== 'o' || x == 'u') {
                        vowels += 1;
                    } else if (x == '!' || x == ',' || x == '.' ||  x== '?' ) {
                        punct += 1;
                    } else if (Character.isWhitespace(x)) {
                        continue;
                    } else {
                        consonant += 1;
                    }

                }
            }


            File file = new File("output_ex1.txt");
            PrintStream out = new PrintStream(file);
            out.println("Vowels :" + vowels );
            out.println("Consonants :" + consonant );
            out.println("Punctuation :" + punct );

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
