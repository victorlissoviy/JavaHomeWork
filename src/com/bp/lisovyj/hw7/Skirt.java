package com.bp.lisovyj.hw7;

public class Skirt extends Clothes implements WomanClothes {
    private String name;

    public Skirt(String name, Size size, int cost, String color) {
        this.name = name;
        setSize(size);
        setCost(cost);
        setColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void dressWomen() {
        System.out.println(name + " має розмір: " + getSize() + ", ціну: " + getCost() + " і колір: " + getColor());
    }
}
