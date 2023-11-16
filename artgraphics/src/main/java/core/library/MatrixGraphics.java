package core.library;

import core.Main;
import elements.Element;

public class MatrixGraphics extends Element {

    private Matrix matrix;

    public MatrixGraphics(Main launcher, float x, float y, float w, float h, Matrix matrix) {
        super(launcher, x, y, w, h);
        this.matrix = matrix;
    }
    
    public void draw() {
        launcher.pushMatrix();
        launcher.translate(x, y);
        launcher.translate(w/2 - matrix.getWidth()/2, h/2 - matrix.getHeight()/2);
        matrix.draw();
        launcher.popMatrix();
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
