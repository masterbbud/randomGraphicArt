package core.library.matrices;

import java.util.ArrayList;

import core.library.Bubble;
import core.library.Matrix;
import core.library.MatrixBounds;
import processing.core.PVector;

public class BubbleMatrix extends AngleSpacingMatrix {
    public BubbleMatrix(int width, int height, float offset, float xspacing, float yspacing, ArrayList<Bubble> bubbles) {
        super(width, height, offset, xspacing, yspacing);
        boolean found = false;
        ArrayList<PVector> toRemove = new ArrayList<PVector>();
        for (PVector p : positions) {
            found = false;
            PVector shifted = new PVector(p.x - width/2, p.y - height / 2);
            for (Bubble b : bubbles) {
                if (b.isPointInRadius(shifted)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                toRemove.add(p);
            }
        }
        for (PVector p : toRemove) {
            positions.remove(p);
        }
    }

    public static BubbleMatrix create(float offset, float xspacing, float yspacing, ArrayList<Bubble> bubbles) {
        float minX = 0;
        float minY = 0;
        float maxX = 0;
        float maxY = 0;
        boolean done = false;
        for (Bubble b : bubbles) {
            PVector p = b.pos;
            if (!done) {
                minX = p.x - b.size;
                maxX = p.x + b.size;
                minY = p.y - b.size;
                maxY = p.y + b.size;
                done = true;
            }
            else {
                if (p.x - b.size < minX) {
                    minX = p.x - b.size;
                }
                if (p.x + b.size > maxX) {
                    maxX = p.x + b.size;
                }
                if (p.y - b.size < minY) {
                    minY = p.y - b.size;
                }
                if (p.y + b.size > maxY) {
                    maxY = p.y + b.size;
                }
            }
        }
        int width = (int)Math.ceil(maxX - minX);
        int height = (int)Math.ceil(maxY - minY);
        return new BubbleMatrix(width, height, offset, xspacing, yspacing, bubbles);
    }    
}
