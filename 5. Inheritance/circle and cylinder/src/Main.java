public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println(circle);

        Cylinder cylinder = new Cylinder(3, 4);
        System.out.println(cylinder);
        System.out.println(cylinder.calDienTichMatCau());
    }
}