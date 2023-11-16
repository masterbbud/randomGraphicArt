package core.library.noises;

import core.library.Noise;
import processing.core.PVector;

public class IntNoise extends Noise {

    protected int numValues;
    protected int[][] noise;

    public IntNoise(int grain, int numValues) {
        super(grain);
        this.numValues = numValues;
        // should throw error if numValues is 0
        generateNoise();
    }

    protected void generateNoise() {
        noise = new int[grain][grain];
        for (int x = 0; x < grain; x++) {
            for (int y = 0; y < grain; y++) {
                noise[x][y] = (int)Math.floor(Math.random() * numValues);
            }
        }
    }

    public int getNoiseAt(PVector v) {
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
