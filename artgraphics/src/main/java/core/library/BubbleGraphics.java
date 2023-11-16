package core.library;

import java.util.ArrayList;

import core.ArtGraphics;
import core.Main;
import elements.Element;
import processing.core.PVector;

public class BubbleGraphics extends Element {

    private ArrayList<Bubble> bubbles = new ArrayList<Bubble>();

    public BubbleGraphics(Main launcher, float x, float y, float w, float h) {
        super(launcher, x, y, w, h);
        bubbles.add(new Bubble(new PVector(0,0), Settings.bubbleSize));
    }

    public void draw() {
        launcher.pushMatrix();
        launcher.translate(x, y);
        launcher.translate(w/2, h/2);
        launcher.fill(255);
        // if (launcher.mousePressed) {
        //     addBubble();
        // }
        for (Bubble b : bubbles) {
            launcher.ellipse(b.pos.x, b.pos.y, b.size * 2, b.size * 2);
        }
        launcher.popMatrix();
    }

    public void addBubble() {
        float currentSize = (float)Math.pow(2, -1 * Settings.bubbleSizeRate * bubbles.size()) * Settings.bubbleSize;
        float randAngle = (float)(Math.random() * 2 * Math.PI);
        PVector furthest = new PVector(bubbles.size() * Settings.bubbleSize * 2 + 1, 0).rotate(randAngle);
        Bubble newBubble = new Bubble(furthest, currentSize);
        while (true) {
            for (Bubble b : bubbles) {
                if (b.isBubbleInRadius(newBubble)) {
                    bubbles.add(newBubble);
                    return;
                }
            }
            newBubble.pos.sub(new PVector(newBubble.pos.x, newBubble.pos.y).normalize().mult(newBubble.size * Settings.bubbleGrain));
        }
    }

    public void multSize(float scale) {
        for (Bubble b : bubbles) {
            b.size *= scale;
        }
    }

    public ArrayList<Bubble> getBubbles() {
        return bubbles;
    }
}
