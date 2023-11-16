package core.library;

import processing.core.PVector;

public class Bubble {
    public PVector pos;
    public float size;

    public Bubble(PVector pos, float size) {
        this.pos = pos;
        this.size = size;
    }

    public boolean isBubbleInRadius(Bubble other) {
        return Math.sqrt(Math.pow(pos.x - other.pos.x, 2) + Math.pow(pos.y - other.pos.y, 2)) <= size + other.size;
    }

    public boolean isPointInRadius(PVector other) {
        return Math.sqrt(Math.pow(pos.x - other.x, 2) + Math.pow(pos.y - other.y, 2)) <= size;
    }
}
