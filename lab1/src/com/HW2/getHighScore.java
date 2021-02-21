package com.HW2;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class getHighScore {
    public static void main(String[] args) {
        String filename = null;
    Display(GetPlayer(ReadScores(filename)));
    }

    public static Scanner  ReadScores(String filename ){
        Scanner scan = null;
      try{
        scan = new Scanner(filename);
          System.out.println(scan.next());
          Dictionary result =GetPlayer(scan);
          Display(result);
    } catch (Exception e) {
          System.out.println("error occured");
      }
      return scan;
      }

        public static @NotNull
        Dictionary GetPlayer(Scanner scan){

        Dictionary result = new Hashtable();
        while (scan.hasNextLine()){
            String player = scan.nextLine();
            String score = scan.nextLine();
            result.put(player,score);
        }
        return result;
    }
        public static void Display(Dictionary in){
        Enumeration out = in.keys();
        while (out.hasMoreElements()) {
            Object d = out.nextElement();
            System.out.println(d +"  score is  "+in.get(d));
        }
    }
}
