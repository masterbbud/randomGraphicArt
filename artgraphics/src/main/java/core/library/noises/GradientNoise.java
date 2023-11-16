package core.library.noises;

import core.library.Noise;

public class GradientNoise extends BooleanNoise {
    
    public GradientNoise(int grain) {
        super(grain);
        generateNoise();
    }

    protected void generateNoise() {
        noise = new boolean[grain][grain];
        for (int x = 0; x < grain; x++) {
            for (int y = 0; y < grain; y++) {
                if (Math.random() > (float)x / grain) {
                    noise[x][y] = false;
                }
                else {
                    noise[x][y] = true;
                }
            }
        }
    }
    
}
