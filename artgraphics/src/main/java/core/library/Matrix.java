package core.library;

import java.util.ArrayList;

import core.library.matrices.AngleSpacingMatrix;
import core.library.matrices.BubbleMatrix;
import processing.core.PVector;

public abstract class Matrix {
    protected ArrayList<PVector> positions;
    protected Shape shape;
    protected ColorMap colorMap;

    protected MatrixBounds bounds;

    public Matrix() {

    }

    

    public static Matrix fromAngleSpacing(int width, int height, float offset, float xspacing, float yspacing) {
        return new AngleSpacingMatrix(width, height, offset, xspacing, yspacing);
    }

    public static Matrix fromBubbles(float offset, float xspacing, float yspacing, ArrayList<Bubble> bubbles) {
        return BubbleMatrix.create(offset, xspacing, yspacing, bubbles);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setColorMap(ColorMap colorMap) {
        this.colorMap = colorMap;
    }

    public void draw() {
        for (PVector p : positions) {
            shape.setColor(colorMap.map(bounds.mapVectorIntoSpace(p)));
            shape.drawAt(p.x, p.y);
        }
    }

    protected void setBounds() {
        float minX = 0;
        float minY = 0;
        float maxX = 0;
        float maxY = 0;
        boolean done = false;
        for (PVector p : positions) {
            if (!done) {
                minX = p.x;
                maxX = p.x;
                minY = p.y;
                maxY = p.y;
                done = true;
            }
            else {
                if (p.x < minX) {
                    minX = p.x;
                }
                if (p.x > maxX) {
                    maxX = p.x;
                }
                if (p.y < minY) {
                    minY = p.y;
                }
                if (p.y > maxY) {
                    maxY = p.y;
                }
            }
        }
        bounds = new MatrixBounds(minX, maxX, minY, maxY);
    }

    public float getWidth() {
        return bounds.maxX - bounds.minX;
    }

    public float getHeight() {
        return bounds.maxY - bounds.minY;
    }
}
