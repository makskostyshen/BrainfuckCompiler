package executor.executable.blocks;

import executor.Memory;

public class Cycle extends Block {

    @Override
    public String toString() {
        return "cycle" + getSyntaxUnits();
    }


    @Override
    public void execute(Memory memory){
        while(memory.getCurrentCell() != 0){
            super.execute(memory);
        }
    }
}
