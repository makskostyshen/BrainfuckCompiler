package interpreter;

import interpreter.SymbolConverter;
import interpreter.commands.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolConverterTest {

    @Test
    void plusIsIncrease(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('+');

        assertTrue(returnedCommand instanceof AddIncreaseValueInstruction);
    }

    @Test
    void minusIsDecrease(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('-');

        assertTrue(returnedCommand instanceof AddDecreaseValueInstruction);
    }

    @Test
    void leftTriangleBracketIsPrevious(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('<');

        assertTrue(returnedCommand instanceof AddPreviousCellInstruction);
    }

    @Test
    void rightTriangleBracketIsPrevious(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('>');

        assertTrue(returnedCommand instanceof AddNextCellInstruction);
    }

    @Test
    void leftRectangleBracketIsNextCycle(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('[');

        assertTrue(returnedCommand instanceof OpenCycle);
    }

    @Test
    void rightRectangleBracketIsNextCycle(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand(']');

        assertTrue(returnedCommand instanceof CloseCycle);
    }

    @Test
    void dotIsPrint(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('.');

        assertTrue(returnedCommand instanceof AddPrintValueInstruction);
    }

    @Test
    void otherSymbolIsnull(){
        SynthesizingCommand returnedCommand = SymbolConverter.getSynthesizingCommand('a');

        assertTrue(returnedCommand == null);
    }

}