package compiler.instructions;

/**
 * Command,
 * adds instruction of increasing current memory unit
 */
public class AddIncreaseValueInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor){

        visitor.visit(this);
    }
}
