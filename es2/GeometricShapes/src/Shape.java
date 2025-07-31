package es2.GeometricShapes.src;

import java.util.List;


/**
 *
 * Immaginiamo di voler fare una figura. E di questa figura calcolare perimetro ed area. Il primo problema
 * nasce dal fatto che ogni figura, a seconda di QUALE figura sia, ha una formula diversa per il calcolo dell'area.
 * E' quindi chiaro che Shape NON PUO' essere una classe semplice, in quanto una "figura" non è un oggetto, ma descrive
 * un insieme più "ampio".
 *
 * Dal momento che "Shape" è generico, possiamo crearlo come classe "astratta". Una classe
 * astratta permette di definire le interfacce di metodi che verranno poi implementati nella
 * specializzazione della classe astratta, e di definire metodi che invece non sono astratti e
 * possono essere "usati" da una specializzazione della classe astratta.
 *
 * Avere i metodi astratti getArea(), getPerimeter() e getSequenceOfPointToDraw() fa si che
 * qualsiasi classe che "estende" shape vada ad implementare questi metodi. Ovviamente,
 * ogni classe potrà implementarlo in maniera consona alla propria figura.
 *
 *
 */

public abstract class Shape {
    // Computes the area
    public abstract double getArea();

    // Computes the perimeter
    public abstract double getPerimeter();


    /**
     * Returns the list of points to connect to draw the figure
     *
     * @return List of points to connect
     */
    public abstract List<Point> getSequenceOfPointsToDraw();

    /**
     * Draws the figure on the canvas
     *
     * @param canvas
     */
    public void draw(TwoDimensionalCanvas canvas) {
        List<Point> points = getSequenceOfPointsToDraw();
        for (int i = 0; i < points.size() - 1; i++) {
            canvas.drawLine(points.get(i), points.get(i + 1));
        }
        canvas.drawLine(points.get(points.size() - 1), points.get(0));
    }
}
