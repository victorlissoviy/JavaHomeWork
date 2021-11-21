package com.bp.lisovyj.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        Scanner in = new Scanner(System.in);
        boolean error = false;
        do{
            System.out.print("Введіть логін: ");
            String login = in.nextLine();
            System.out.print("Введіть пароль: ");
            String password = in.nextLine();
            System.out.print("Повторіть пароль: ");
            String confirmPassword = in.nextLine();
            try{
                auth.signUp(login, password, confirmPassword);
                System.out.println("Нового користувача створено успішно\nАвторизація");
                error = false;
            }catch(WrongLoginException | WrongPasswordException e){
                error = true;
                System.out.println(e.getMessage());
                System.out.println("Спробуйте ще раз");
            }
        }while(error);
        do{
            System.out.print("Введіть логін: ");
            String login = in.nextLine();
            System.out.print("Введіть пароль: ");
            String password = in.nextLine();
            try{
                auth.signIn(login, password);
                System.out.println("Вітаємо вас, " + login + ", в системі!");
                error = false;
            }catch(WrongLoginException | WrongPasswordException e){
                error = true;
                System.out.println(e.getMessage());
                System.out.println("Спробуйте ще раз");
            }
        }while(error);
        in.close();
    }
}
