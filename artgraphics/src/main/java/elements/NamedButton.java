package elements;

import core.Main;
import datatypes.Color;

public class NamedButton extends Button {

    protected String name;

    public NamedButton(Main launcher, float x, float y, float w, float h, Color color, int layer,
            Executable executable, String name) {
        super(launcher, x, y, w, h, color, layer, executable);
        this.name = name;
    }
    
    public void draw() {
        super.draw();
        Label.setTextSize(launcher, name, w*0.8f, h*0.8f);
        color.getBWTextColor().setFill(launcher);
        launcher.text(name, x+w/2, y+h*0.8f);
    }
}
