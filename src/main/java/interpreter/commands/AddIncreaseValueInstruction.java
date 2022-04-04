package interpreter.commands;

import interpreter.BlockCreator;
import executor.executable.instructions.IncreaseCellValue;

/**
 * Command,
 * adds instruction of increasing current memory unit
 */
public class AddIncreaseValueInstruction extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .addInstruction(new IncreaseCellValue());
    }
}
