package com.bp.lisovyj.hw6;

public class Dog extends Animal{
    private String favoriteToy;

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, String food, String location, String favoriteToy){
        super(name, food, location);
        this.favoriteToy = favoriteToy;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    public void favoriteGame(){
        System.out.println(name + " грається з " + favoriteToy);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) &&
                favoriteToy.equals(((Dog) obj).favoriteToy);
    }

    @Override
    public String toString() {
        return "[" + super.toString() +
                ", Улюблене місце: " + favoriteToy + "]";
    }
}
