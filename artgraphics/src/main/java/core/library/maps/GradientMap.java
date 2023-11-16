package core.library.maps;

import datatypes.Color;
import core.library.ColorMap;
import processing.core.PVector;

public class GradientMap extends ColorMap {

    private Color lerpFrom;
    private Color lerpTo;
    private float angle;

    public GradientMap(Color lerpFrom, Color lerpTo, float angle) {
        this.lerpFrom = lerpFrom;
        this.lerpTo = lerpTo;
        this.angle = angle;
    }
    
    public Color map(PVector position) {
        double rads = Math.toRadians(angle);

        PVector toFindMax = new PVector(0.5f, 0.5f).rotate((float)rads);
        float maxColor = Math.max(Math.abs(toFindMax.x), Math.abs(toFindMax.y));

        PVector angleVector = new PVector((float)Math.cos(rads), (float)Math.sin(rads)).mult(maxColor);
        PVector proj = project(PVector.sub(position, new PVector(0.5f, 0.5f)), angleVector);
        float result = PVector.sub(proj, angleVector).mag();
        return lerpTo.lerpToColor(lerpFrom, result);
    }
}
