package interpreter;

import interpreter.commands.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Converts symbol to synthesizing command
 * /
 * if symbol is incorrect - gives null
 */

public abstract class SymbolConverter {

    public static final Map<Character, SynthesizingCommand> sourceCodeToSynthesizingCommand = new HashMap(){{
        put('>', new AddNextCellInstruction());
        put('<', new AddPreviousCellInstruction());
        put('+', new AddIncreaseValueInstruction());
        put('-', new AddDecreaseValueInstruction());
        put('.', new AddPrintValueInstruction());
        put('[', new OpenCycle());
        put(']', new CloseCycle());
    }};

    public static SynthesizingCommand getSynthesizingCommand(char symbol){
        return sourceCodeToSynthesizingCommand.get(symbol);
    }
}
