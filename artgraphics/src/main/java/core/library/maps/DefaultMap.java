package core.library.maps;

import datatypes.Color;
import core.library.ColorMap;
import processing.core.PVector;

public class DefaultMap extends ColorMap {

    public Color map(PVector position) {
        return Color.WHITE;
    }
    
}
