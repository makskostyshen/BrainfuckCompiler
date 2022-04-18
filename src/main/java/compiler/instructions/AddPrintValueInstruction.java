package compiler.instructions;

/**
 * Command,
 * adds instruction of printing to the current memory unit
 */
public class AddPrintValueInstruction implements Instruction {

    @Override
    public void acceptVisitor(InstructionVisitor visitor){

        visitor.visit(this);
    }
}
