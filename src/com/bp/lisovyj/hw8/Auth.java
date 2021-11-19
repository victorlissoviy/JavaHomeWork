package com.bp.lisovyj.hw8;

import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        setLogin(login);
        setPassword(password, confirmPassword);
    }

    public void signIn(String login, String password) throws WrongLoginException, WrongPasswordException {
        if(!(login.equals(getLogin()) && password.equals(getPassword(login)))){
            throw new WrongPasswordException("Логін або пароль не співпадають.");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws WrongLoginException {
        if(!Pattern.compile("[a-zA-Z0-9]{5,20}").matcher(login).find()){
            throw new WrongLoginException("Логін не відповідає правилам.");
        }
        this.login = login;
    }

    public String getPassword(String login) throws WrongLoginException {
        if(login.equals(this.login)){
            return password;
        }else{
            //Тут точно не знаю який правильно Exeption зробити
            throw new WrongLoginException("Цей користувач, " + login + ", не може отримати пароль.");
        }
    }

    public void setPassword(String password, String confirm) throws WrongPasswordException {
        if(!password.equals(confirm)){
            throw new WrongPasswordException("Паролі не співпадають.");
        }
        if(!Pattern.compile("[a-zA-Z0-9_]{5,}").matcher(password).find()){
            throw new WrongPasswordException("Пароль не відповідає правилам.");
        }
        this.password = password;
    }

}
