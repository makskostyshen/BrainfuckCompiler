package executor.executable.blocks;

import executor.Memory;
import executor.executable.Executable;

import java.util.ArrayList;
import java.util.List;

/**
 * Block of instructions, can be executed with memory
 * /
 * Parent of Cycle
 * /
 * If instance is not Cycle, used only once - as an external block
 * of instructions
 */
public class Block implements Executable {

    private List<Executable> syntaxUnits = new ArrayList<>();

    public List<Executable> getSyntaxUnits() {
        return syntaxUnits;
    }

    public void add(Executable executable){
        syntaxUnits.add(executable);
    }

    @Override
    public void execute(Memory memory){
        for(Executable executable : syntaxUnits){
            executable.execute(memory);
        }
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Block)){
            return false;
        }
        Block otherBlock = (Block)other;

        return syntaxUnits.equals(otherBlock.syntaxUnits);
    }


    @Override
    public String toString() {
        return "block" + syntaxUnits;
    }
}
