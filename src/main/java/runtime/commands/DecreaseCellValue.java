package runtime.commands;

import runtime.Memory;

public class DecreaseCellValue extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.decreaseCurrentCell();
    }



}
