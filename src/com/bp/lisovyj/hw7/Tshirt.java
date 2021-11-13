package com.bp.lisovyj.hw7;

public class Tshirt extends Clothes implements ManClothes, WomanClothes {
    private String name;

    public Tshirt(String name, Size size, int cost, String color) {
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
    public void dressMan() {
        System.out.println(name + " має розмір: " + getSize() + ", ціну: " + getCost() + " і колір: " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println(name + " має розмір: " + getSize() + ", ціну: " + getCost() + " і колір: " + getColor());
    }
}
