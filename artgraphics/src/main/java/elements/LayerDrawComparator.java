package elements;

import java.util.Comparator;

public class LayerDrawComparator implements Comparator<Element> {
    public int compare(Element a, Element b) {
        return a.layer - b.layer;
    }
}
