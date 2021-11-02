package com.bp.lisovyj.hw6;

public class Veterinarian {
    public void treatAnimal(Animal animal){
        System.out.println(animal.getName() + " їсть " + animal.getFood() +
                " і знаходиться " + animal.getLocation());
        if(animal instanceof Cat){
            System.out.println("Це кіт і його улюблене місце " + ((Cat)animal).getFavoriteLocation());
        }else if(animal instanceof Dog){
            System.out.println("Це собака і її улюблена іграшка " + ((Dog)animal).getFavoriteToy());
        }else if(animal instanceof Horse){
            System.out.println("Це кінь і його улюблений шлях " + ((Horse)animal).getFavoriteWay());
        }
    }
}
