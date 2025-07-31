package es2.GeometricShapes.src;

/**
 *
 * Class representing a point
 *
 */
public class Point {
    private final double x;
    private final double y;

    /**
     * Constructs a point given an x and y variables
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Rotates a point given a reference point of rotation
     *
     * @param center point of rotation
     * @param degrees degrees of rotation
     * @return rotated point
     */
    public Point rotate(Point center, double degrees) {
        double rotatedX = center.x + (x - center.x) * Math.cos(degrees) - (y - center.y) * Math.sin(degrees);
        double rotatedY = center.y + (x - center.x) * Math.sin(degrees) + (y - center.y) * Math.cos(degrees);
        return new Point(rotatedX, rotatedY);
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }
}