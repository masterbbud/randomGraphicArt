package elements;

import core.Main;
import datatypes.Color;
import processing.core.PImage;

public class Image extends Element {

    protected PImage image;
    protected boolean stretchMode;

    public Image(Main launcher, float x, float y, float w, float h, int layer, PImage image, boolean stretchMode) {
        super(launcher, x, y, w, h, layer);
        this.image = image;
        this.stretchMode = stretchMode;
    }

    public Image(Main launcher, float x, float y, float w, float h, int layer, PImage image) {
        this(launcher, x, y, w, h, layer, image, false);
    }

    public void draw() {
        if (stretchMode) {
            System.out.println("Unable to print Image as stretchMode is unimplemented");
        }
        else {
            launcher.image(image, x, y, w, h);
        }
    }
}
