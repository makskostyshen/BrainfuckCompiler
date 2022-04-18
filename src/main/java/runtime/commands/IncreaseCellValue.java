package runtime.commands;

import runtime.Memory;

public class IncreaseCellValue extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.increaseCurrentCell();
    }
}
