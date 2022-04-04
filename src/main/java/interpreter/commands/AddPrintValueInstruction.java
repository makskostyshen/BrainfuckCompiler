package interpreter.commands;

import interpreter.BlockCreator;
import executor.executable.instructions.PrintCell;

/**
 * Command,
 * adds instruction of printing to the current memory unit
 */
public class AddPrintValueInstruction extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .addInstruction(new PrintCell());
    }
}
