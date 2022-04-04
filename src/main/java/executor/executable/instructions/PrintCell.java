package executor.executable.instructions;

import executor.Memory;

public class PrintCell extends Instruction {

    @Override
    public void execute(Memory memory){
        byte byteToPrint = memory.getCurrentCell();
        System.out.print((char)byteToPrint);
    }
}