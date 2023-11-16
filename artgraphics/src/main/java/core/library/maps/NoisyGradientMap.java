package core.library.maps;

import datatypes.Color;
import core.library.ColorMap;
import core.library.noises.GradientNoise;
import processing.core.PVector;

public class NoisyGradientMap extends ColorMap {

    private Color lerpFrom;
    private Color lerpTo;
    private float angle;
    private GradientNoise noise;

    public NoisyGradientMap(Color lerpFrom, Color lerpTo, float angle) {
        this.lerpFrom = lerpFrom;
        this.lerpTo = lerpTo;
        this.angle = angle;
        System.out.println("Started noise");
        noise = new GradientNoise(1000);
        System.out.println("Finished noise");
    }
    
    public Color map(PVector position) {
        double rads = Math.toRadians(angle);

        PVector toFindMax = new PVector(0.5f, 0.5f).rotate((float)rads);
        float maxColor = Math.max(Math.abs(toFindMax.x), Math.abs(toFindMax.y));

        PVector angleVector = new PVector((float)Math.cos(rads), (float)Math.sin(rads)).mult(maxColor);
        PVector proj = project(PVector.sub(position, new PVector(0.5f, 0.5f)), angleVector);
        float result = PVector.sub(proj, angleVector).mag();
        
        PVector newAngleVector = angleVector.rotate((float)Math.PI/2);
        PVector orthoProj = project(PVector.sub(position, new PVector(0.5f, 0.5f)), newAngleVector);
        float orthoResult = PVector.sub(orthoProj, newAngleVector).mag();
        boolean which = noise.getNoiseAt(new PVector(result, orthoResult));
        if (which) {
            return lerpFrom;
        }
        else {
            return lerpTo;
        }
    }
}