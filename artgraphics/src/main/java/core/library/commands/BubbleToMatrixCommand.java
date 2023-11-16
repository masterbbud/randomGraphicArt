package core.library.commands;

import core.ArtGraphics;
import core.Main;

public class BubbleToMatrixCommand extends Command {

    public BubbleToMatrixCommand(ArtGraphics main) {
        super(main);
    }

    public void execute() {
        main.createFromBubbles();
    }
    
}
