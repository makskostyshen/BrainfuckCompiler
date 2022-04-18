package compiler.instructions;

/**
 * Command,
 * closes cycle in the block
 */
public class CloseCycleInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor){

        visitor.visit(this);
    }
}
