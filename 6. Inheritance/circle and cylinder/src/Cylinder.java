public class Cylinder extends Circle{
    double height;
    double theTich;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calTheTich() {
        return super.calDienTichMatCau() * this.height;
    }

    @Override
    public String toString() {
        return "Hình trụ có bán kính: "
                + this.radius
                +" Độ cao: "
                + this.height
                + " Màu sắc: "
                + this.color;
    }
}
