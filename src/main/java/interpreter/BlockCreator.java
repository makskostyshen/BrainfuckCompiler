package interpreter;

import exceptions.BracketsException;
import executor.executable.Executable;
import executor.executable.blocks.Block;
import executor.executable.blocks.Cycle;

import java.util.Stack;

/**
 * Wrapper for creating block of instructions
 * /
 * Contains methods for adding simple instructions and cycles
 * to block
 */

public class BlockCreator {

    private Block externalBlock;
    private Stack<Block> nestedBlocks; //opened cycles inside each other

    public BlockCreator() {
        externalBlock = new Block();
        nestedBlocks = new Stack<>();
        nestedBlocks.push(externalBlock);
    }

    /**
     * @return created block of instructions
     * /
     * @throws BracketsException if not all cycles were closed
     */
    public Block getCreatedExternalBlock() throws BracketsException{
        if(!areAllCyclesClosed()){
            throw new BracketsException();
        }
        return externalBlock;
    }

    /**
     * Adds simple instruction to block
     * /
     * @param executable - instruction
     */
    public void addInstruction(Executable executable){
        Block blockToAdd = nestedBlocks.peek();
        blockToAdd.add(executable);
    }


    public void openCycle(){
        nestedBlocks.add(new Cycle());
    }

    /**
     * @throws BracketsException if no cycle was opened before
     */
    public void closeCycle() throws BracketsException{
        if(areAllCyclesClosed()){
            throw new BracketsException();
        }
        Block closedBlock = nestedBlocks.pop();
        Block blockToAdd = nestedBlocks.peek();
        blockToAdd.add(closedBlock);
    }


    private boolean areAllCyclesClosed(){
        return nestedBlocks.size()==1;
    }

}
