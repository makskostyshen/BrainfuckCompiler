package executor.executable.instructions;

import executor.Memory;

public class DecreaseCellValue extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.decreaseCurrentCell();
    }



}
