package com.bp.lisovyj.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private String favoriteLocation;

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, String food, String location, String favoriteLocation){
        super(name, food, location);
        this.favoriteLocation = favoriteLocation;
    }

    public String getFavoriteLocation() {
        return favoriteLocation;
    }

    public void setFavoriteLocation(String favoriteLocation) {
        this.favoriteLocation = favoriteLocation;
    }

    public void goToFavoriteLocation(){
        System.out.println(name + " в своєму улюбленмому місці " + favoriteLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, food, location, favoriteLocation);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) &&
                this.favoriteLocation.equals(((Cat) obj).favoriteLocation);
    }

    @Override
    public String toString() {
        return "[" + super.toString() +
                ", Улюблене місце: " + favoriteLocation + "]";
    }
}
