package interpreter;

import exceptions.BracketsException;
import executor.executable.blocks.Block;
import executor.executable.instructions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {

//    these tests are generalizing, more are in:
//                        BlockCreatorTest
//                        SymbolConverterTest

    @Test
    void emptyInputIsEmptyBlock(){

        //returned
        Interpreter interpreter = new Interpreter("");
        Block returnedBlock = interpreter.interpret();


        //expected
        BlockCreator creator = new BlockCreator();
        Block expectedBlock = creator.getCreatedExternalBlock();

        assertTrue(expectedBlock.equals(returnedBlock));
    }

    @Test
    void basicInputIsBasicBlock(){

        //returned
        Interpreter interpreter = new Interpreter(
                "+-[.->]<");
        Block returnedBlock = interpreter.interpret();


        //expected
        BlockCreator creator = new BlockCreator();
        creator.addInstruction(new IncreaseCellValue());
        creator.addInstruction(new DecreaseCellValue());
        creator.openCycle();
        creator.addInstruction(new PrintCell());
        creator.addInstruction(new DecreaseCellValue());
        creator.addInstruction(new NextCell());
        creator.closeCycle();
        creator.addInstruction(new PreviousCell());
        Block expectedBlock = creator.getCreatedExternalBlock();

        assertTrue(expectedBlock.equals(returnedBlock));
    }

    @Test
    void wrongBracketsIsError(){

        //expected error
        Interpreter interpreter = new Interpreter("]");
        assertThrows(BracketsException.class,
                () -> {interpreter.interpret();});
    }


}