package elements;

import java.util.ArrayList;

import core.Main;

public class ElementList extends Element {

    protected ArrayList<Element> elements;
    protected float elementHeight;
    protected float spacing;
    
    public ElementList(Main launcher, float x, float y, float w, float h, float elementHeight, float spacing, int layer) {
        super(launcher, x, y, w, h, layer);
        this.elementHeight = elementHeight;
        this.spacing = spacing;
        this.elements = new ArrayList<Element>();
    }

    public void addButton(Button button) {
        elements.add(button);
        button.x = x;
        button.y = y + getCurrentHeight();
        button.w = w;
        button.h = elementHeight;
    }
    
    protected float getCurrentHeight() {
        float counter = 0;
        for (Element b : elements) {
            counter += b.h;
            counter += spacing;
        }
        return counter;
    }

    public void draw() {
        for (Element b : elements) {
            b.draw();
        }
    }

    public boolean tryClick() {
        for (Element b : elements) {
            if (b.tryClick()) {
                return true;
            }
        }
        return false;
    }

    public boolean tryHover(boolean isSomethingHovered) {
        boolean found = isSomethingHovered;
        for (Element b : elements) {
            if (b.tryHover(found)) {
                found = true;
            }
        }
        return isSomethingHovered;
    }
}
