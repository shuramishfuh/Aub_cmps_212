package com.Lab6;
public class Square extends Shape{
    private int lenght;
    public  Square(int lenght){
        this.setLenght(lenght);}

    @Override
    public double getArea(){
        return 4* this.getLenght();
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}