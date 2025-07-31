package es2.GeometricShapes.src;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class representing a square
 *
 */
public class Square extends Shape {

    private final Point initialPoint;
    // Rotation in radiant degrees of the square
    private final double orientation;
    private final double sideLength;

    /**
     *
     * @param intialPoint starting point of the square
     * @param orientation rotation
     * @param sideLength length of the side
     */
    public Square(Point intialPoint, double orientation, double sideLength) {
        if (intialPoint == null || sideLength < 0 || orientation < 0 || orientation > 2 * Math.PI) {
            throw new IllegalArgumentException();
        }
        this.initialPoint = intialPoint;
        this.orientation = orientation;
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public List<Point> getSequenceOfPointsToDraw() {
        List<Point> points = new ArrayList<Point>();
        points.add(initialPoint);
        Point nonOrientedSecondPoint = new Point(initialPoint.getX(), initialPoint.getY() + sideLength);
        points.add(nonOrientedSecondPoint.rotate(initialPoint, orientation));
        Point nonOrientedThirdPoint = new Point(initialPoint.getX() + sideLength, initialPoint.getY() + sideLength);
        points.add(nonOrientedThirdPoint.rotate(initialPoint, orientation));
        Point nonOrientedFourthPoint = new Point(initialPoint.getX() + sideLength, initialPoint.getY());
        points.add(nonOrientedFourthPoint.rotate(initialPoint, orientation));
        return points;
    }
}
