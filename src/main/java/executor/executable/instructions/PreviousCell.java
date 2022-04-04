package executor.executable.instructions;

import executor.Memory;

public class PreviousCell extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.pointerMoveBackward();
    }
}
