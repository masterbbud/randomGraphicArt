package core.library;

import processing.core.PVector;

public abstract class Noise {
    
    protected int grain;

    public Noise(int grain) {
        this.grain = grain;
    }

    protected abstract void generateNoise();
}
