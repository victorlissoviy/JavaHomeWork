package com.bp.lisovyj.hw4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {
    public static int countChars(String text, String line){
        int r = 0;
        int i = text.indexOf(line);
        while (i != -1){
            r += 1;
            i = text.indexOf(line, i + 1);
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text1 = in.nextLine().toLowerCase();
        String text2 = in.nextLine().toLowerCase();
        in.close();
        Pattern pattern = Pattern.compile("[a-zа-я]");
        Matcher m = pattern.matcher(text1);
        boolean isAnagram = true;
        while (m.find()) {
            String line = m.group();
            if(countChars(text1, line) != countChars(text2, line)){
                isAnagram = false;
                break;
            }
        }
        if(isAnagram){
            System.out.println("is Anagram");
        }else{
            System.out.println("is not anagram");
        }
    }
}
