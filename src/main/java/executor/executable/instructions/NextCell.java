package executor.executable.instructions;

import executor.Memory;

public class NextCell extends Instruction {

    @Override
    public void execute(Memory memory){
        memory.pointerMoveForward();
    }
}
