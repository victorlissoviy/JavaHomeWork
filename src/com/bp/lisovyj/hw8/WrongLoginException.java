package com.bp.lisovyj.hw8;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(){
        super();
    }
    public WrongLoginException(String text){
        super(text);
    }
}
