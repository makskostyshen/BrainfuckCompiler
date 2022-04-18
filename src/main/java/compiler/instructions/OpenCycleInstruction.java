package compiler.instructions;

/**
 * Command,
 * opens cycle in the block
 */
public class OpenCycleInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor){

        visitor.visit(this);
    }
}
