package elements;

import java.util.ArrayList;

import core.Main;

public class Stack extends Element {
    
    private ArrayList<Element> children;

    public Stack(Main launcher, float x, float y, float w, float h, Element[] elements) {
        super(launcher, x, y, w, h);
        for (Element e : elements) {
            children.add(e);
            e.x += x;
            e.y += y;
        }
    }

    public void draw() {
        for (Element e : children) {
            e.draw();
        }
    }
}
