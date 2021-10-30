package com.bp.lisovyj.hw5;

public class Library {
    public static void main(String[] args) {
        final int n = 3;
        Book[] books = new Book[n];
        books[0] = new Book("Приключения", "Иванов И. И.", 2000);
        books[1] = new Book("Словарь", "Сидоров А. В.", 1980);
        books[2] = new Book("Энциклопедия", "Гусев К. В.", 2010);

        for(Book book: books){
            System.out.println(book);
        }
        System.out.println();

        Reader[] readers = new Reader[n];
        readers[0] = new Reader("Ельвіра", "Чала", "Михайлівна", "12.01.2001", 818, "ОТІУС");
        readers[1] = new Reader("Віктор", "Лісовий", "Юрійович", "02.03.1993", 800, "ННІ ФМ та КІС", "+380939328243");
        readers[2] = new Reader("Денис", "Коломієць", "Ігорович", "08.11.1995", 735, "ННІ ФМ та КІС");

        for(Reader reader: readers){
            System.out.println(reader);
        }
        System.out.println();

        readers[0].takeBook(3);
        readers[1].takeBook("Приключения", "Словарь", "Энциклопедия");
        readers[2].takeBook(books);
        System.out.println();

        readers[0].returnBook(2);
        readers[1].returnBook("Приключения", "Энциклопедия");
        readers[2].returnBook(books[0], books[2]);
    }
}
