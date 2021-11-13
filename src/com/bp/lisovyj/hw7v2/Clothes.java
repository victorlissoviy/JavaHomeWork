package com.bp.lisovyj.hw7v2;

interface ManClothes {
    void dressMan();
}

interface WomanClothes {
    void dressWomen();
}

public abstract class Clothes {
    private String name;
    private Size size;
    private int cost;
    private String color;

    public Clothes(String name, Size size, int cost, String color) {
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
