package compiler.instructions;

/**
 * Command used to operate Compiler -
 * synthesize block inside
 * /
 * Command pattern is used
 */
public interface Instruction {

    void acceptVisitor(InstructionVisitor visitor);

}
