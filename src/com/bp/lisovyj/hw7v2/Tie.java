package com.bp.lisovyj.hw7v2;

public class Tie extends Clothes implements ManClothes {

    public Tie(String name, Size size, int cost, String color) {
        super(name, size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println(getName() + " має " + getSize().getDescription() + ": " + getSize() + " (" + getSize().getEuroSize() + "), ціну: " + getCost() + " і колір: " + getColor());
    }
}
