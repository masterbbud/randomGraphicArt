package core.library.noises;

public class SmoothGradientNoise extends IntNoise {

    public SmoothGradientNoise(int grain, int numValues) {
        super(grain, numValues);
    }

    protected void generateNoise() {
        noise = new int[grain][grain];
        for (int x = 0; x < grain; x++) {
            for (int y = 0; y < grain; y++) {
                noise[x][y] = (int)Math.floor(Math.random() * numValues);
            }
        }
    }
}
