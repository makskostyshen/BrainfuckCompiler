package runtime.commands;

import runtime.Memory;

public class PreviousCell extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.pointerMoveBackward();
    }
}
