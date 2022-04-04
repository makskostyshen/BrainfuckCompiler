package interpreter.commands;

import interpreter.BlockCreator;

/**
 * Command used to operate BlockCreator -
 * synthesize block inside
 * /
 * Command pattern is used
 */
public abstract class SynthesizingCommand {

    public abstract void synthesize(BlockCreator blockCreator);

    @Override
    public boolean equals(Object other){
        return this.getClass() == other.getClass();
    }
}
