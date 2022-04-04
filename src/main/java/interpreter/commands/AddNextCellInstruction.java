package interpreter.commands;

import interpreter.BlockCreator;
import executor.executable.instructions.NextCell;

/**
 * Command,
 * adds instruction of moving to the next memory unit
 */
public class AddNextCellInstruction extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .addInstruction(new NextCell());
    }
}
