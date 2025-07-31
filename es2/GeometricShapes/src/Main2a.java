package es2.GeometricShapes.src;

/**
* Test class
**/

public class Main2a {
    public static void main(String[] args) {
        Shape s = new Square(new Point(0, 0), 4.0, 2);
        System.out.println("L'area è: " + s.getArea());
        System.out.println("Il perimetro è: " + s.getPerimeter());
        Shape s2 = new Circle(new Point(0, 0), 5.0);
        TwoDimensionalCanvas canvas = new BasicCanvas(1024, 1024, new Point(-10,-10), new Point(10,10));
        s.draw(canvas);
        s2.draw(canvas);
    }
}
