package es2.GeometricShapes.src;

/**
 * L'obiettivo è rappresentare delle figure geometriche.
 *
 * Avremo quindi, DA DISEGNARE, delle figure bidimensionali, che possono avere lati o meno.
 * Per prima cosa, ragioniamo per strati. L'interfaccia Two Dimensional Canvas,
 * descrive un "comportamento", e deve fornire l'interfaccia, ovvero quei metodi che,
 * indipendentemente dalla figura, sono propri di una figura bidimensionale.
 *
 * Pensando agli elementi bidimensionali, possiamo avere:
 * punti, figure con lati (ovvero insiemi di segmenti) e cerchi.
 *
 * Serviranno quindi i metodi:
 * 1. DrawPoint
 * 2. DrawLine
 * 3. DrawCircle
 *
 * Questi metodi, sono sufficienti per rappresentare le figure bidimensionali.
 *
 * Ovviamente, in java "cerchio", "punto" e "linea" non significano nulla. Sono oggetti che vanno implementati.
 * Nel fare ciò, ricordiamo però che:
 * 1. Per DISEGNARE un punto, ci serve l'oggetto "Point".
 * 2. Per DISEGNARE un segmento, ci servono di fatto due punti.
 * 3. Per DISEGNARE un cerchio, ci serve un punto, ed un valore di raggio.
 *
 * Una volta definito ciò che vogliamo disegnare, DOBBIAMO definire quindi la classe "POINT"
 *
 */
public interface TwoDimensionalCanvas {

    /**
     * Draw a point
     *
     * @param point point to draw
     */
    void drawPoint(Point point);

    /**
     * Draw a line
     *
     * @param firstEndPoint starting point
     * @param secondEndPoint end point
     */
    void drawLine(Point firstEndPoint, Point secondEndPoint);

    /**
     * Draw a circle
     *
     * @param center circle center
     * @param radius circle radius
     */
    void drawCircle(Point center, double radius);
}