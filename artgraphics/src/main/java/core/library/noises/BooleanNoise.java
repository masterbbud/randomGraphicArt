package core.library.noises;

import core.library.Noise;
import processing.core.PVector;

public class BooleanNoise extends Noise {
    
    public BooleanNoise(int grain) {
        super(grain);
        generateNoise();
    }

    protected boolean[][] noise;

    protected void generateNoise() {
        noise = new boolean[grain][grain];
        for (int x = 0; x < grain; x++) {
            for (int y = 0; y < grain; y++) {
                if (Math.random() > 0.5) {
                    noise[x][y] = false;
                }
                else {
                    noise[x][y] = true;
                }
            }
        }
    }

    public boolean getNoiseAt(PVector v) {
        PVector clamped = new PVector(v.x, v.y);
        if (v.x >= 1) {
            clamped.x = 0.999999f;
        }
        if (v.y >= 1) {
            clamped.y = 0.999999f;
        }
        return noise[(int)Math.floor(clamped.x * grain)][(int)Math.floor(clamped.y * grain)];
    }
}
