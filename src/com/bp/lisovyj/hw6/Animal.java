package com.bp.lisovyj.hw6;

import java.util.Objects;

public class Animal {
    protected String food;
    protected String location;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, String food){
        this(name);
        this.food = food;
    }

    public Animal(String name, String food, String location){
        this(name, food);
        this.location = location;
    }

    public void makeNoise(){
        System.out.println(name + " cтворює шум");
    }

    public void eat(){
        System.out.println(name + " їсть " + food);
    }

    public void sleep(){
        System.out.println(name + " спить в " + location);
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, food, location);
    }

    @Override
    public boolean equals(Object obj) {
        return location.equals(((Animal) obj).location) &&
                name.equals(((Animal) obj).name) &&
                food.equals(((Animal) obj).food);
    }

    @Override
    public String toString() {
        return "ім'я: " + name +
                ", Місце: " + location +
                ", Їжа: " + food;
    }
}
