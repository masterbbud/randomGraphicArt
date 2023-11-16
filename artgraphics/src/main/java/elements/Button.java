package elements;

import core.Main;
import datatypes.Color;

public class Button extends Element {

    protected Executable executable;
    
    public Button(Main launcher, float x, float y, float w, float h, Color color, int layer, Executable executable) {
        super(launcher, x, y, w, h, color, layer);
        this.executable = executable;
    }

    public void click() {
        executable.execute();
    }

    public void draw() {
        super.setupDraw();
        if (isHovered) {
            color.lighter().setFill(launcher);
        }
        launcher.rect(x, y, w, h, Math.max(Math.min(w/10, h/10), 2));
    }
}
