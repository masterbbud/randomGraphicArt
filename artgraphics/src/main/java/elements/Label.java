package elements;

import core.Main;
import datatypes.Color;
import processing.core.PApplet;

public class Label extends Element {
    
    private String text;

    public Label(Main launcher, float x, float y, float w, float h, int layer, Color stroke, String text) {
        super(launcher, x, y, w, h, layer);
        this.stroke = stroke;
        this.color = stroke;
        this.text = text;
    }

    public void draw() {
        super.setupDraw();
        launcher.text(text, x, y);
    }

    public static void setTextSize(Main launcher, String name, float width, float height) {
        launcher.textSize(100);
        float currentWidth = launcher.textWidth("m");
        launcher.textSize(height * 100 / currentWidth);
        if (launcher.textWidth(name) > width) {
            launcher.textSize((height * 100 / currentWidth) / (launcher.textWidth(name) / width));
            launcher.textAlign(PApplet.CENTER, PApplet.BASELINE);
        }
    }
}
