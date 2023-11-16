package elements;

import core.Main;
import datatypes.Color;

public class Panel extends Element {

    public Panel(Main launcher, float x, float y, float w, float h, Color color, int layer) {
        super(launcher, x, y, w, h, color, layer);
    }
 
    public void draw() {
        super.setupDraw();
        launcher.rect(x, y, w, h);
    }
}
