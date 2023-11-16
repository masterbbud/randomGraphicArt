package core.library;

import processing.core.PVector;

public class MatrixBounds {
    
    public float minX;
    public float maxX;
    public float minY;
    public float maxY;

    public MatrixBounds(float minX, float maxX, float minY, float maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public PVector mapVectorIntoSpace(PVector vector) {
        return new PVector(
            (vector.x - minX) / (maxX - minX),
            (vector.y - minY) / (maxY - minY)
        );
    }
}
