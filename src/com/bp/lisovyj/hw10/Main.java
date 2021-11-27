package com.bp.lisovyj.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Float> numFloat = new NumBox<>(10);
        numFloat.add(1F);
        numFloat.add(5F);
        numFloat.add(9F);
        System.out.println(numFloat.sum());
        System.out.println(numFloat.length());
        System.out.println(numFloat.average());
        System.out.println(numFloat.max());

        NumBox<Integer> numInteger = new NumBox<>(7);
        numInteger.add(12);
        numInteger.add(24);
        numInteger.add(36);
        System.out.println(numInteger.average());
        System.out.println(numInteger.get(2));
    }
}
