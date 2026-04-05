public class Point2d {
    float x;
    float y;

    public Point2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] XY = {this.x, this.y};
        return XY;
    }

    public void setXY(float[] XY) {
        this.x = XY[0];
        this.y = XY[1];
    }

    @Override
    public String toString() {
        return String.valueOf(this.x)
                + String.valueOf(this.y);
    }
}
