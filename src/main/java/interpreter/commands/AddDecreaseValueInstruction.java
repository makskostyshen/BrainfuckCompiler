package interpreter.commands;

import interpreter.BlockCreator;
import executor.executable.instructions.DecreaseCellValue;

/**
 * Command,
 * adds instruction of decreasing current memory unit
 */
public class AddDecreaseValueInstruction extends SynthesizingCommand {

    @Override
    public void synthesize(BlockCreator blockCreator){
        blockCreator
                .addInstruction(new DecreaseCellValue());
    }

}
