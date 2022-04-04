package executor.executable.instructions;

import executor.Memory;

public class IncreaseCellValue extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.increaseCurrentCell();
    }
}
