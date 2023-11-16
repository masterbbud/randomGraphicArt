package core.library.maps;

import java.util.ArrayList;

import datatypes.Color;
import core.library.ColorMap;
import core.library.noises.GradientNoise;
import core.library.noises.IntNoise;
import processing.core.PVector;

public class PaletteMap extends ColorMap{

    private IntNoise noise;
    private ArrayList<Color> colors;

    public PaletteMap(ArrayList<Color> colors) {
        this.colors = colors;
        noise = new IntNoise(1000, colors.size());
    }

    public Color map(PVector position) {
        return colors.get(noise.getNoiseAt(position));
    }
}
