package compiler.instructions;

/**
 * Command,
 * adds instruction of moving to the previous memory unit
 */
public class AddPreviousCellInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor) {

        visitor.visit(this);
    }
}
