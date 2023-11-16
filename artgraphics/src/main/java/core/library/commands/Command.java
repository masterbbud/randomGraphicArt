package core.library.commands;

import core.ArtGraphics;
import core.Main;
import elements.Executable;

public abstract class Command implements Executable {

    protected ArtGraphics main;
    
    public Command(ArtGraphics main) {
        this.main = main;
    }
    public abstract void execute();
}
