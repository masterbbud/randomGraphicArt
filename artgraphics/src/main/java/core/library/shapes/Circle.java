package core.library.shapes;

import core.Main;
import datatypes.Color;
import core.library.Shape;

public class Circle extends Shape {

    public Circle(Main main, Color color, float scale) {
        super(main, color, scale);
        main.ellipseMode(Main.CENTER);
    }

    public void draw() {
        main.ellipse(0, 0, scale, scale);
    }
}
