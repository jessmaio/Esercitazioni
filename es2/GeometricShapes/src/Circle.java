package es2.GeometricShapes.src;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Un cerchio è una figura, quindi estende "shape". Dal momento che Shape è una classe astratta, ne deve
 * necessariamente implementare i metodi astratti.
 *
 */
public class Circle extends Shape {
    private final Point center;
    private final double radius;

    /**
     * Constructs a circle shape from a center and a radius
     *
     * @param center center of the circle
     * @param radius radius of the circle
     */
    public Circle(Point center, double radius) {
        if (center == null || radius < 0) {
            throw new IllegalArgumentException();
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public List<Point> getSequenceOfPointsToDraw() {
        // We approximate the circle as a polygon of 256 sides!
        List<Point> points = new ArrayList<Point>();
        int numberOfSegments = 256;
        for (int i = 0; i < numberOfSegments; i++) {
            double newPointX = center.getX() + radius * Math.cos(2 * Math.PI * i / numberOfSegments);
            double newPointY = center.getY() + radius * Math.sin(2 * Math.PI * i / numberOfSegments);
            points.add(new Point(newPointX, newPointY));
        }
        return points;
    }

    @Override
    public void draw(TwoDimensionalCanvas canvas) {
        canvas.drawCircle(center, radius);
    }
}