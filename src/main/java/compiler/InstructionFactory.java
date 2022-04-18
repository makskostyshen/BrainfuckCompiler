package compiler;

import compiler.instructions.AddDecreaseValueInstruction;
import compiler.instructions.AddIncreaseValueInstruction;
import compiler.instructions.AddNextCellInstruction;
import compiler.instructions.AddPreviousCellInstruction;
import compiler.instructions.AddPrintValueInstruction;
import compiler.instructions.CloseCycleInstruction;
import compiler.instructions.Instruction;
import compiler.instructions.OpenCycleInstruction;

import java.util.HashMap;
import java.util.Map;

/**
 * Converts symbol to synthesizing command
 * /
 * if symbol is incorrect - gives null
 */
class InstructionFactory {

    private final Map<Character, Instruction> instructions =
            new HashMap() {{
                put('>', new AddNextCellInstruction());
                put('<', new AddPreviousCellInstruction());
                put('+', new AddIncreaseValueInstruction());
                put('-', new AddDecreaseValueInstruction());
                put('.', new AddPrintValueInstruction());
                put('[', new OpenCycleInstruction());
                put(']', new CloseCycleInstruction());
            }};

    Instruction create(char symbol) {

        if (!instructions.containsKey(symbol)) {

            throw new IllegalArgumentException(
                    "Unknown brainfuck instruction: " + symbol);
        }

        return instructions.get(symbol);
    }
}
