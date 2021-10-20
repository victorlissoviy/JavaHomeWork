package com.bp.lisovyj.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(101);
        int i;
        int tryes = 0;
        Scanner in = new Scanner(System.in);
        do{
            tryes += 1;
            System.out.print("Enter num from 0 to 100 (or another to exit):");
            try {
                i = in.nextInt();
            }catch (Exception e){
                System.out.println("Goodbye!");
                break;
            }
            if(i < 0 || i > 100){
                System.out.println("Goodbye!");
                break;
            }
            if(i > num){
                System.out.println("less");
            }else if(i < num){
                System.out.println("more");
            }else{
                System.out.println("Bingo!!!\nYou tryes: " + tryes);
                break;
            }
        }while(true);
    }
}
