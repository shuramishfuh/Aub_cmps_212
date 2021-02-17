package com.lab3;

import java.util.Random;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {

        System.out.println("Welcome to treasure hunt!\n");
        System.out.println("Treasure coordinates randomly generated...\n");
        int chestx=generatRandomPositiveNegitiveValue(4,-4);
        int chesty=generatRandomPositiveNegitiveValue(4,-4);
        int userx =0;
        int usery =0;
        Scanner in  = new Scanner(System.in);
        treasureStatus(chestx,chesty,userx,usery) ;
        while((userx >-5 && userx<5) && (usery >-6 && usery<6)){
            System.out.println("Enter direction (U, D, L, R)");
            char   option = in.next().charAt(0);

                if(option == 'U'){
                usery += 1;
                treasureStatus(chestx, chesty, userx, usery);
            }
                 if(option == 'D'){
                    usery-=1;
                    treasureStatus(chestx,chesty,userx,usery);
                 }
                 if(option == 'L'){
                    userx-=1;
                    treasureStatus(chestx,chesty,userx,usery);
                 }
                 if(option == 'R'){
                    usery+=1;
                    treasureStatus(chestx,chesty,userx,usery);
                 }
            }
        if(Math.abs((usery - chesty) + (userx - chestx))!=0)
            System.out.println("You reached the end of the cave… you lost!");
        else
            System.out.println("Game ended");
    }
    public static int generatRandomPositiveNegitiveValue(int max , int min) {
        Random random = new Random();
       return random.nextInt(max - min) + min;

    }
    public static void treasureStatus(int chestx, int chesty ,int Userx , int Usery){
        if (Userx == chestx && Usery == chesty){
            System.out.println("You Found the treasure");
        } else  {
            System.out.println("Manhattan distance to chest :"+ Math.abs((Usery - chesty) + (Userx - chestx)));
        }
    }
}
