package com.bp.lisovyj.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] text = in.nextLine().split(" ");
        StringBuilder newText = new StringBuilder();
        for (String s : text) {
            if(s.length() != 0){
                newText.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
            }
        }
        System.out.println(newText.toString().replace("\n", " "));
        in.close();
    }
}
