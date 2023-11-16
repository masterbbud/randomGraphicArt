package core.library.shapes;

import core.Main;
import datatypes.Color;
import core.library.Shape;

public class Diamond extends Shape {
    public Diamond(Main main, Color color, float scale) {
        super(main, color, scale);
    }

    public void draw() {
        main.beginShape();
        main.vertex(scale/3, 0);
        main.vertex(0, scale/2);
        main.vertex(-scale/3, 0);
        main.vertex(0, -scale/2);
        main.endShape(Main.CLOSE);
    }
}
