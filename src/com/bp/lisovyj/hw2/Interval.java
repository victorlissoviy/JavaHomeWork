package com.bp.lisovyj.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter num:");
        int num = in.nextInt();
        if(num >= 0 && num <= 14){
            System.out.println("Number in 0-14");
        }else if(num >= 15 && num <= 35){
            System.out.println("Number in 15-35");
        }else if(num >= 36 && num <= 50){
            System.out.println("Number in 36-50");
        }else if(num >= 51 && num <= 100){
            System.out.println("Number in 51-100");
        }else{
            System.out.println("Number not in 0-100");
        }
        in.close();
    }
}
