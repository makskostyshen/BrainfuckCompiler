package compiler;

import compiler.instructions.AddDecreaseValueInstruction;
import compiler.instructions.AddIncreaseValueInstruction;
import compiler.instructions.AddNextCellInstruction;
import compiler.instructions.AddPreviousCellInstruction;
import compiler.instructions.AddPrintValueInstruction;
import compiler.instructions.CloseCycleInstruction;
import compiler.instructions.Instruction;
import compiler.instructions.InstructionVisitor;
import compiler.instructions.OpenCycleInstruction;
import runtime.commands.Command;
import runtime.commands.Cycle;
import runtime.commands.DecreaseCellValue;
import runtime.commands.IncreaseCellValue;
import runtime.commands.NextCell;
import runtime.commands.PreviousCell;
import runtime.commands.PrintCell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Wrapper for creating block of instructions
 * /
 * Contains methods for adding simple instructions and cycles
 * to block
 */

public class Compiler implements InstructionVisitor {

    private final Deque<List<Command>> stack = new ArrayDeque<>();
    private final InstructionFactory factory = new InstructionFactory();
    private final String program;

    public Compiler(String program) {

        this.program = program;
        stack.push(new ArrayList<>());
    }

    public List<Command> compile() {

        for (char sourceSymbol : program.toCharArray()) {

            // command used to operate block creator
            Instruction currentInstruction = factory.create(sourceSymbol);

            currentInstruction.acceptVisitor(this);
        }

        if (stack.size() != 1) {
            throw new BracketsException();
        }

        return stack.pop();
    }


    @Override
    public void visit(AddDecreaseValueInstruction instruction) {

        addCommand(new DecreaseCellValue());
    }

    /**
     * Adds simple instruction to block
     * /
     *
     * @param command - instruction
     */
    private void addCommand(Command command) {

        stack.peek().add(command);
    }

    @Override
    public void visit(AddIncreaseValueInstruction instruction) {

        addCommand(new IncreaseCellValue());
    }

    @Override
    public void visit(AddNextCellInstruction instruction) {

        addCommand(new NextCell());
    }

    @Override
    public void visit(AddPreviousCellInstruction instruction) {

        addCommand(new PreviousCell());
    }

    @Override
    public void visit(AddPrintValueInstruction instruction) {

        addCommand(new PrintCell());
    }

    @Override
    public void visit(CloseCycleInstruction instruction) {

        if (stack.size() < 2) {
            throw new BracketsException();
        }

        List<Command> innerCycleCommands = stack.pop();
        addCommand(new Cycle(innerCycleCommands));
    }

    @Override
    public void visit(OpenCycleInstruction instruction) {

        stack.push(new ArrayList<>());
    }
}
