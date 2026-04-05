public class Main {
    public static void main(String[] args) {
        Point2d point2d = new Point2d(2, 3);
        System.out.println(point2d);
        float[] XY = {43, 52};
        point2d.setXY(XY);
        System.out.println(point2d);

        Point3d point3d = new Point3d(3, 4, 5);
        System.out.println(point3d);
        float[] XYZ = point3d.getXYZ();
        System.out.println(XYZ[2]);
    }
}