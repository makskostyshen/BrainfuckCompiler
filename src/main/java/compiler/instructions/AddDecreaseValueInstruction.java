package compiler.instructions;

/**
 * Command,
 * adds instruction of decreasing current memory unit
 */
public class AddDecreaseValueInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor){

        visitor.visit(this);
    }
}
