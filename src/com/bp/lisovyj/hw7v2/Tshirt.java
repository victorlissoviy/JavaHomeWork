package com.bp.lisovyj.hw7v2;

public class Tshirt extends Clothes implements ManClothes, WomanClothes {

    public Tshirt(String name, Size size, int cost, String color) {
        super(name, size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println(getName() + " має " + getSize().getDescription() + ": " + getSize() + " (" + getSize().getEuroSize() + "), ціну: " + getCost() + " і колір: " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println(getName() + " має " + getSize().getDescription() + ": " + getSize() + " (" + getSize().getEuroSize() + "), ціну: " + getCost() + " і колір: " + getColor());
    }
}
