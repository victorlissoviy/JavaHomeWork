package com.bp.lisovyj.hw5;

/**
 * Reader зберігає інфомрацію про читача бібліотеки
 */
public class Reader {
    private final String name;
    private final String lastName;
    private final String surname;
    private final int number;
    private String faculty;
    private final String dateBirth;
    private String telephone;

    public String getFIO(){
        return lastName + " " + name.charAt(0) + ". " + surname.charAt(0) + ".";
    }

    /**
     * Виводить на екран яку кількість книг взяв читач
     * @param n - кількість книг
     */
    public void takeBook(int n){
        StringBuilder out = new StringBuilder();
        out.append("Читач ");
        out.append(getFIO());
        out.append(" взяв ");
        out.append(n);
        out.append(" книг");
        if(n % 10 == 1){
            out.append("у");
        }else if(n % 10 < 5) {
            out.append("и");
        }
        System.out.println(out);
    }

    /**
     * Виводить на екран назви книг які взяв читач
     * @param names - список назв книг
     */
    public void takeBook(String... names){
        StringBuilder out = new StringBuilder();
        out.append("Читач ");
        out.append(getFIO());
        out.append(" взяв книги: ");
        for(String name: names){
            out.append(name).append(", ");
        }
        out.delete(out.length() - 2, out.length() - 1);
        System.out.println(out);
    }

    /**
     * Виводить на екран інформацію про книги які взяв читач
     * @param books - список книг
     */
    public void takeBook(Book... books){
        StringBuilder out = new StringBuilder();
        out.append("Читач ");
        out.append(getFIO());
        out.append(" взяв книги: ");
        for(Book book: books){
            out.append(book).append(", ");
        }
        out.delete(out.length() - 2, out.length() - 1);
        System.out.println(out);
    }

    /**
     * Виводить на екран яку кількість книг повернув читач
     * @param n - кількість книг
     */
    public void returnBook(int n){
        StringBuilder out = new StringBuilder();
        out.append("Читач ");
        out.append(getFIO());
        out.append(" повернув ");
        out.append(n);
        out.append(" книг");
        if(n % 10 == 1){
            out.append("у");
        }else if(n % 10 < 5) {
            out.append("и");
        }
        System.out.println(out);
    }

    /**
     * Виводить на екран назви книг які повернув читач
     * @param names - список назв книг
     */
    public void returnBook(String... names){
        StringBuilder out = new StringBuilder();
        out.append("Читач ");
        out.append(getFIO());
        out.append(" повернув книги: ");
        for(String name: names){
            out.append(name).append(", ");
        }
        out.delete(out.length() - 2, out.length() - 1);
        System.out.println(out);
    }

    /**
     * Виводить на екран інформацію про книги які повернув читач
     * @param books - список книг
     */
    public void returnBook(Book... books){
        StringBuilder out = new StringBuilder();
        out.append("Читач ");
        out.append(getFIO());
        out.append(" повернув книги: ");
        for(Book book: books){
            out.append(book).append(", ");
        }
        out.delete(out.length() - 2, out.length() - 1);
        System.out.println(out);
    }

    @Override
    public String toString() {
        String s = getFIO() +
                ":\nномер читацького білету: " + number +
                "\nдата народження: " + dateBirth;
        if(faculty != null && !faculty.isEmpty()) {
            s += "\nфакультет: " + faculty;
        }
        if(telephone != null && !telephone.isEmpty()){
            s += "\nтелефон: " + telephone;
        }
        return s;
    }

    public Reader(String name, String lastName, String surname, String dateBirth, int number){
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.number = number;
    }

    public Reader(String name, String lastName, String surname, String dateBirth, int number, String faculty){
        this(name, lastName, surname, dateBirth, number);
        this.faculty = faculty;
    }

    public Reader(String name, String lastName, String surname, String dateBirth, int number, String faculty, String telephone){
        this(name, lastName, surname, dateBirth, number, faculty);
        this.telephone = telephone;
    }
}
