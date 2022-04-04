package interpreter.commands;

import interpreter.BlockCreator;

/**
 * Command,
 * closes cycle in the block
 */
public class CloseCycle extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .closeCycle();
    }
}
