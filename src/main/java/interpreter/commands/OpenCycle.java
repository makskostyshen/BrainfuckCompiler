package interpreter.commands;

import interpreter.BlockCreator;

/**
 * Command,
 * opens cycle in the block
 */
public class OpenCycle extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .openCycle();
    }
}
