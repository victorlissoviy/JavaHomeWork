package com.bp.lisovyj.hw5;

/**
 * Book зберігає інформацію про книгу
 */
public class Book {
    private String name;
    private String author;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Book(){

    }

    public Book(String name){
        this.name = name;
    }

    public Book(String name, String author){
        this(name);
        this.author = author;
    }

    public Book(String name, String author, int year){
        this(name, author);
        this.year = year;
    }

    public String toString(){
        return name + " (" + author + " " + year + " р.)";
    }
}
