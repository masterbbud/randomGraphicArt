package core;

import java.util.ArrayList;

import elements.Element;
import elements.LayerClickComparator;
import elements.LayerDrawComparator;
import processing.core.PApplet;

public class Main extends PApplet {

    protected static final int WIDTH = 1000;
    protected static final int HEIGHT = 1000;
    protected static final int FRAME_RATE = 30;
    protected ArrayList<Element> elements;
    protected boolean isMousePressed = false;


    public static void main(String[] args) {
        PApplet.main(new String[] {"core.Main"});
    }

    public void settings() {
        size(WIDTH, HEIGHT);
        
        elements = new ArrayList<Element>();
    }

    public void setup() {
        frameRate(FRAME_RATE);
        ellipseMode(CENTER);
    }

    public void draw() {
        background(64);
        elements.sort(new LayerDrawComparator());
        for (Element e : elements) {
            if (e.isHidden()) {
                continue;
            }
            e.draw();
        }
        elements.sort(new LayerClickComparator());
        boolean isSomethingHovered = false;
        for (Element e : elements) {
            if (e.isHidden()) {
                continue;
            }
            if (e.tryHover(isSomethingHovered)) {
                isSomethingHovered = true;
            }
            if (e.tryClick()) {
                isMousePressed = true;
            }
        }
    }

    public void mouseReleased() {
        isMousePressed = false;
    }

    public boolean isMousePressed() {
        return isMousePressed;
    }

    public float fixedDeltaTime() {
        return 1f / FRAME_RATE;
    }
}