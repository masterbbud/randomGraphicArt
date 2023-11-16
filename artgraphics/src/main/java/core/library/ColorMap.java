package core.library;

import datatypes.Color;
import processing.core.PVector;

public abstract class ColorMap {
    
    public abstract Color map(PVector position);

    protected PVector project(PVector from, PVector onto) {
        return PVector.mult(onto, ((from.dot(onto)) / (onto.dot(onto))));
    }
}
