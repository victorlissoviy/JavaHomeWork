package com.bp.lisovyj.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter num1:");
        int operand1 = in.nextInt();
        System.out.print("Enter num2:");
        int operand2 = in.nextInt();
        System.out.print("Enter oper(+,-,*,/):");
        String sign = in.next();
        switch (sign){
            case "+":{
                System.out.println("Result: " + (operand1 + operand2));
                break;
            }
            case "-":{
                System.out.println("Result: " + (operand1 - operand2));
                break;
            }
            case "*":{
                System.out.println("Result: " + (operand1 * operand2));
                break;
            }
            case "/":{
                if(operand2 != 0){
                    System.out.println("Result: " + (operand1 / operand2));
                }else{
                    System.out.println("Error: num2 is 0");
                }
                break;
            }
        }
        in.close();
    }
}
