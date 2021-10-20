package com.bp.lisovyj.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int n = 10;
        int sum = 0;
        int nums = 0;
        int[] mas = new int[n];
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            System.out.print("Enter mas[" + (i + 1) + "]:");
            mas[i] = in.nextInt();
            sum += mas[i];
            if(mas[i] >= 0){
                nums += 1;
            }
        }
        in.close();
        System.out.println("Sum: " + sum);
        System.out.println("Num of positive elements: " + nums);
        System.out.println("Mas: " + Arrays.toString(mas));
        int N = mas.length;
        do{
            int newn = 0;
            for(int i = 1;i < N; i+=1){
                if(mas[i - 1] > mas[i]){
                    int temp = mas[i - 1];
                    mas[i - 1] = mas[i];
                    mas[i] = temp;
                    newn = i;
                }
            }
            N = newn;
        }while (N > 1);
        System.out.println("New mas: " + Arrays.toString(mas));
    }
}
