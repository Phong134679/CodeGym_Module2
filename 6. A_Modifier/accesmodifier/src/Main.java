class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Circle 1:");
        System.out.println("Radius: " + c1.getRadius());
        System.out.println("Area: " + c1.getArea());


        Circle c2 = new Circle(2.5);
        System.out.println("Circle 2:");
        System.out.println("Radius: " + c2.getRadius());
        System.out.println("Area: " + c2.getArea());
    }
}