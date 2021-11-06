package com.bp.lisovyj.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String favoriteWay;

    public Horse(String name) {
        super(name);
    }

    public Horse(String name, String food, String location, String favoriteWay){
        super(name, food, location);
        this.favoriteWay = favoriteWay;
    }

    public String getFavoriteWay() {
        return favoriteWay;
    }

    public void setFavoriteWay(String favoriteWay) {
        this.favoriteWay = favoriteWay;
    }

    public void goFavoriteWay(){
        System.out.println(name + " бігає улюбленим шляхом: " + favoriteWay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, food, location, favoriteWay);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && favoriteWay.equals(((Horse) obj).favoriteWay);
    }

    @Override
    public String toString() {
        return "[" + super.toString() +
                ", Улюблене місце: " + favoriteWay + "]";
    }
}
