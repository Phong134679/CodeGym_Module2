package com.codegym;

public class Rectangle extends Shape implements resize, colorable{
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString()
                + howToColor();
    }

    @Override
    public void reSize(double percent) {
        if (percent > 0) {
            this.width *= percent;
            this.length *= percent;
        } else {
            System.out.println("Phần trăm phải lớn hơn 0");
        }
    }

    @Override
    public String howToColor() {
        return " Color all four sides.";
    }
}