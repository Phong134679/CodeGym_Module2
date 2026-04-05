public class Circle {
    double radius;
    String color = "Chưa khởi tạo. ";
    double dienTichMatCau;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double calDienTichMatCau() {
        return this.radius*3.14;
    }

    @Override
    public String toString() {
        return "Mặt cầu có bán kính: "
                + this.radius
                + " Màu sắc: "
                + this.color;
    }
}
