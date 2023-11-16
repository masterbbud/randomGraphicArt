package core.library.matrices;

import java.util.ArrayList;

import core.library.Matrix;
import processing.core.PVector;

public class AngleSpacingMatrix extends Matrix {
    public AngleSpacingMatrix(int width, int height, float offset, float xspacing, float yspacing) {
        int rowIndex = 0;
        float off = 0;
        positions = new ArrayList<PVector>();
        for (float x = 0; x < width; x += xspacing) {
            if (rowIndex % 2 == 1) {
                off = offset * yspacing;
            }
            else {
                off = 0;
            }
            for (float y = off; y < height; y += yspacing) {
                positions.add(new PVector(x, y));
            }
            rowIndex ++;
        }
        setBounds();
    }
}
