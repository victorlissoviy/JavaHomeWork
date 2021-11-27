package com.bp.lisovyj.hw10;

public class NumBox <T extends Number> {
    private final T[] list;
    private final int size;
    private int index;

    public NumBox(int size) {
        index = 0;
        this.size = size;
        list = (T[]) new Number[size];
    }

    public void add(T t){
        if(index >= size) {
            throw new IndexOutOfBoundsException("Вихід за межі масиву");
        }
        list[index] = t;
        index += 1;
    }

    public T get(int index){
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Вихід за межі масиву");
        }
        return list[index];
    }

    public int length(){
        return index;
    }

    public double sum(){
        double sum = 0;
        for(T num : list){
            if(num == null){
                break;
            }
            sum += num.doubleValue();
        }
        return sum;
    }

    public double average(){
        return sum() / length();
    }

    public T max(){
        T max = list[0];
        for(T num : list){
            if(num == null){
                break;
            }
            if(max.doubleValue() < num.doubleValue()){
                max = num;
            }
        }
        return max;
    }
}
