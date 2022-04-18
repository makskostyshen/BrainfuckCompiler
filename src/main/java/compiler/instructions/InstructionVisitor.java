package compiler.instructions;

public interface InstructionVisitor {

    void visit(AddDecreaseValueInstruction instruction);

    void visit(AddIncreaseValueInstruction instruction);

    void visit(AddNextCellInstruction instruction);

    void visit(AddPreviousCellInstruction instruction);

    void visit(AddPrintValueInstruction instruction);

    void visit(CloseCycleInstruction instruction);

    void visit(OpenCycleInstruction instruction);
}
