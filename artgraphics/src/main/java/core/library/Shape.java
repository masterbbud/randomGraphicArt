package core.library;

import core.Main;
import datatypes.Color;

public abstract class Shape {

    protected Main main;
    protected Color color;
    protected float scale;

    public Shape(Main main, Color color, float scale) {
        this.main = main;
        this.color = color;
        this.scale = scale;
    }
    
    public void drawAt(float x, float y) {
        main.pushMatrix();
        main.translate(x, y);
        main.fill(color.r, color.g, color.b, color.a);
        main.noStroke();
        draw();
        main.popMatrix();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();

}
