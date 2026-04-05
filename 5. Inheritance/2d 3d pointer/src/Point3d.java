public class Point3d extends Point2d{
    float z;
    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        float[] XYZ = {super.x, super.y, this.z};
        return XYZ;
    }

    public void setXYZ(float[] XYZ) {
        super.x = XYZ[0];
        super.y = XYZ[1];
        this.z = XYZ[2];
    }

    @Override
    public String toString() {
        return String.valueOf(super.x)
                + String.valueOf(super.y)
                + String.valueOf(this.z);
    }
}
