package compiler.instructions;

/**
 * Command,
 * adds instruction of moving to the next memory unit
 */
public class AddNextCellInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor) {

        visitor.visit(this);
    }
}
