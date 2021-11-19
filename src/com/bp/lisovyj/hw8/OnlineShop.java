package com.bp.lisovyj.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть логін: ");
        String login = in.nextLine();
        System.out.print("Введіть пароль: ");
        String password = in.nextLine();
        System.out.print("Повторіть пароль: ");
        String confirmPassword = in.nextLine();
        auth.signUp(login, password, confirmPassword);
        System.out.println("Нового користувача створено успішно\nАвторизація");
        System.out.print("Введіть логін: ");
        login = in.nextLine();
        System.out.print("Введіть пароль: ");
        password = in.nextLine();
        auth.signIn(login, password);
        System.out.println("Вітаємо вас " + login + " в системі!");
        in.close();
    }
}
