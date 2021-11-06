package com.bp.lisovyj.hw6;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        int n = 3;
        Animal[] animals = new Animal[n];

        animals[0] = new Cat("Мурка", "корм", "на руках", "стіл");
        animals[1] = new Dog("Барсік", "м'ясо", "на дивані", "кісточка");
        animals[2] = new Horse("Джордан", "сіно", "на полі", "навколо лісу");

        Object obj = Class.forName("com.bp.lisovyj.hw6.Veterinarian").getConstructor(new Class[]{}).newInstance();
        if(obj instanceof Veterinarian){
            for(Animal a: animals){
                ((Veterinarian)obj).treatAnimal(a);
                System.out.println("-------------------------------------------------");
            }
        }
    }
}
