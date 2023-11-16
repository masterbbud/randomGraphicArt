package core;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

import javax.swing.JColorChooser;

import core.library.Bubble;
import core.library.BubbleGraphics;
import datatypes.Color;
import elements.*;
import core.library.Matrix;
import core.library.MatrixGraphics;
import core.library.Settings;
import core.library.Shape;
import core.library.commands.BubbleToMatrixCommand;
import core.library.commands.GenerateBubblesCommand;
import core.library.maps.GradientMap;
import core.library.maps.NoisyGradientMap;
import core.library.maps.PaletteMap;
import core.library.shapes.*;
import core.Main;

public class ArtGraphics extends Main {
    public static final int WIDTH = 1000;
    private static final int WIDTH_SETTINGS = 500;
    public static final int HEIGHT = 1000;

    private Color backgroundColor = new Color(10);

    private BubbleGraphics bubbleGraphics;
    private MatrixGraphics matrixGraphics;

    private Matrix matrix;

    public static void main(String[] args) {
        PApplet.main(new String[] {"core.ArtGraphics"});
    }

    public void settings() {
        super.settings();
        size(WIDTH+WIDTH_SETTINGS, HEIGHT);
    }

    public void setup() {
        super.setup();
        matrix = Matrix.fromAngleSpacing(WIDTH/2, HEIGHT/2, 0.5f, 13, 22);
        matrix.setShape(new Diamond(this, new Color(100), 20));
        matrix.setColorMap(new NoisyGradientMap(new Color(195, 102, 204), new Color(212, 160, 217), 0));

        bubbleGraphics = new BubbleGraphics(this, 0, 0, WIDTH, HEIGHT);
        matrixGraphics = new MatrixGraphics(this, 0, 0, WIDTH, HEIGHT, matrix);
        bubbleGraphics.show();
        matrixGraphics.hide();

        elements.add(bubbleGraphics);
        elements.add(matrixGraphics);
        elements.add(new Panel(this, WIDTH, 0, WIDTH_SETTINGS, HEIGHT, new Color(100), 100));
        elements.add(new Panel(this, 0, 0, WIDTH+WIDTH_SETTINGS, HEIGHT, backgroundColor, -100));
        ElementList buttons = new ElementList(this, WIDTH+10, 10, WIDTH_SETTINGS - 20, 0, 40, 20, 120);
        elements.add(buttons);
        buttons.addButton(new NamedButton(this, 0, 0, 0, 0, Color.WHITE, 120, new BubbleToMatrixCommand(this), "Generate Matrix From Bubbles"));
        buttons.addButton(new NamedButton(this, 0, 0, 0, 0, Color.WHITE, 120, new GenerateBubblesCommand(this), "Generate Bubbles"));
    }

    private boolean displayBubbles = true;

    public void draw() {
        super.draw();
    }

    public void keyPressed() {
        
    }

    public void generateBubbles() {
        for (int i = 0; i < Settings.numBubbles; i++) {
            bubbleGraphics.addBubble();
        }
    }

    public void createFromBubbles() {
        if (!displayBubbles) {
            return;
        }
        if (Settings.doubleRadii) {
            bubbleGraphics.multSize(2);
        }
        matrix = Matrix.fromBubbles(0.5f, 13, 22, bubbleGraphics.getBubbles());
        matrix.setShape(new Circle(this, new Color(100), 13));
        //matrix.setShape(new Diamond(this, new Color(100), 20));
        matrix.setColorMap(new NoisyGradientMap(new Color(195, 102, 204), new Color(212, 160, 217), 0));
        matrixGraphics.setMatrix(matrix);
        // ArrayList<Color> colors = new ArrayList<Color>();
        // colors.add(new Color(66, 133, 244));
        // colors.add(new Color(219, 68, 55));
        // colors.add(new Color(244, 180, 0));
        // colors.add(new Color(15, 157, 88));
        // matrix.setColorMap(new PaletteMap(colors));
        bubbleGraphics.hide();
        matrixGraphics.show();
    }
}