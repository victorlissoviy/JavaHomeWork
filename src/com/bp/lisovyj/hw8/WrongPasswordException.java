package com.bp.lisovyj.hw8;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(){
        super();
    }
    public WrongPasswordException(String text){
        super(text);
    }
}
