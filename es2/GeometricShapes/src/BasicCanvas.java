package es2.GeometricShapes.src;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

/**
 *
 * Class implementing a two-dimensional canvas.
 */
public class BasicCanvas implements TwoDimensionalCanvas {

    /**
     * Private class extending awt.Canvas
     *
     */
    private class SimpleCanvas extends Canvas {

        private static final long serialVersionUID = 3421617321270607155L;

        private void doDrawing(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;

            for(java.awt.Shape shape : shapes){
                graphics.draw(shape);
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            doDrawing(g);
        }

    }

    private Point origin;

    private Point scale;

    private JFrame frame = new JFrame();

    private List<java.awt.Shape> shapes = new LinkedList<java.awt.Shape>();

    private SimpleCanvas canvas = new SimpleCanvas();

    /**
     * Canvas constructor
     *
     * @param width canvas width
     * @param height canvas height
     * @param origin canvas origin point
     * @param rectangle canvas rectangle
     */
    public BasicCanvas(int width, int height, Point origin, Point rectangle) {
        initUI(width, height);
        this.origin = new Point(origin.getX(), origin.getY());
        this.scale = new Point(((double)width)/(rectangle.getX()-origin.getX()), ((double)height)/(rectangle.getY()-origin.getY()));
    }

    /**
     * returns the coordinate of x with respect to the origin
     *
     * @param p point coordinates
     * @return
     */
    private double rasterX(Point p){
        return ((p.getX()-origin.getX())*scale.getX());
    }

    /**
     * returns the coordinate of y with respect to the origin
     *
     * @param p point coordinates
     * @return
     */
    private double rasterY(Point p){
        return ((p.getY()-origin.getY())*scale.getY());
    }
    @Override
    public void drawLine(Point firstEndPoint, Point secondEndPoint) {
        double x1 = rasterX(firstEndPoint);
        double y1 = rasterY(firstEndPoint);
        double x2 = rasterX(secondEndPoint);
        double y2 = rasterY(secondEndPoint);
        shapes.add(new Line2D.Double(x1, y1, x2, y2));
        canvas.repaint();
    }

    @Override
    public void drawCircle(Point center, double radius) {
        Point firstEndPoint = new Point(center.getX()-radius, center.getY()-radius);
        System.out.println(radius);
        Point secondEndPoint = new Point(2*radius, 2*radius);
        double x1 = rasterX(firstEndPoint);
        double y1 = rasterY(firstEndPoint);
        double x2 = secondEndPoint.getX()*scale.getX();
        double y2 = secondEndPoint.getX()*scale.getY();
        shapes.add(new Ellipse2D.Double(x1, y1, x2, y2));
        canvas.repaint();
    }

    @Override
    public void drawPoint(Point point) {
        double x1 = rasterX(point);
        double y1 = rasterY(point);
        shapes.add(new Ellipse2D.Double(x1-1, y1-1, 2, 2));
        canvas.repaint();
    }

    /**
     * inizializza il frame per la visualizzazione del canvas
     *
     * @param width larghezza del frame
     * @param height altezza del frame
     */
    private void initUI(int width, int height) {
        frame.setTitle("Canvas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

