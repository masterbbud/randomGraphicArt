package core.library.commands;

import core.ArtGraphics;

public class GenerateBubblesCommand extends Command {

    public GenerateBubblesCommand(ArtGraphics main) {
        super(main);
    }

    public void execute() {
        main.generateBubbles();
    }
    
}
