package executor;

import executor.executable.blocks.Block;

/**
 * Handles execution of block of instructions with memory
 */
public class Executor {
    private Memory memory;
    private Block block;

    public Executor(Block block) {
        this.block = block;
        memory = new Memory();
    }

    public Memory getMemory() { //use for testing
        return memory;
    }

    public void execute(){
        block.execute(memory);
    }
}
