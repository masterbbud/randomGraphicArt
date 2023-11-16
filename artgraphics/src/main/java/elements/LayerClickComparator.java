package elements;

import java.util.Comparator;

import elements.Element;

public class LayerClickComparator implements Comparator<Element> {
    public int compare(Element a, Element b) {
        return b.layer - a.layer;
    }
}
