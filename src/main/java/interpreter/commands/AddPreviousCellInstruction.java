package interpreter.commands;

import interpreter.BlockCreator;
import executor.executable.instructions.PreviousCell;

/**
 * Command,
 * adds instruction of moving to the previous memory unit
 */
public class AddPreviousCellInstruction extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .addInstruction(new PreviousCell());
    }
}
