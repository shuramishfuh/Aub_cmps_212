package com.Lab6;


class Circle extends  Shape{

    private double rad;

    public Circle(double rad) {
        this.setRad(rad);
    }

    @Override
    public double getArea() {
        return this.rad*this.rad*Math.PI;
    }

    public double getRad() {
        return rad;
    }

    public void setRad(double rad) {
        this.rad = rad;
    }
}
