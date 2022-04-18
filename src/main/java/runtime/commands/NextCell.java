package runtime.commands;

import runtime.Memory;

public class NextCell extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.pointerMoveForward();
    }
}
