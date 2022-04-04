package executor;

import executor.executable.blocks.Block;
import interpreter.Interpreter;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class MemoryTest {


    Memory getMemoryFromSourceCode(String sourceCode){
        Interpreter interpreter = new Interpreter(sourceCode);
        Block block = interpreter.interpret();

        Executor executor = new Executor(block);
        executor.execute();

        Memory memory = executor.getMemory();
        return memory;
    }

    @Test
    void pointerMoveForwardTest() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode(">");

        //expected
        Memory expectedMemory = new Memory();
        expectedMemory.pointerMoveForward();

        assertTrue(expectedMemory.equals(returnedMemory));
    }

    @Test
    void pointerMoveBackwardTest() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode("<");

        //expected
        Memory expectedMemory = new Memory();
        expectedMemory.pointerMoveBackward();

        assertTrue(expectedMemory.equals(returnedMemory));
    }

    @Test
    void decreaseCurrentCellTest() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode("-");

        //expected
        Memory expectedMemory = new Memory();
        expectedMemory.decreaseCurrentCell();

        assertTrue(expectedMemory.equals(returnedMemory));
    }

    @Test
    void increaseCurrentCellTest() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode("+");

        //expected
        Memory expectedMemory = new Memory();
        expectedMemory.increaseCurrentCell();

        assertTrue(expectedMemory.equals(returnedMemory));
    }

    @Test
    void getCurrentCellTest() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode("+");

        //expected
        Memory expectedMemory = new Memory();
        expectedMemory.increaseCurrentCell();

        assertTrue(expectedMemory.equals(returnedMemory));
    }

    @Test
    void simpleCycleCheck() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode("++++[>+<-]");

        //expected
        Memory expectedMemory = new Memory();
        expectedMemory.pointerMoveForward();
        for(int i = 0; i < 4; i++){
            expectedMemory.increaseCurrentCell();
        }
        expectedMemory.pointerMoveBackward();


        assertTrue(expectedMemory.equals(returnedMemory));
    }

    @Test
    void innerCycleCheck() {

        //returned
        Memory returnedMemory = getMemoryFromSourceCode("++++[>+>--[>+++<+]<<-]>>>");
        System.out.println(returnedMemory);

        //expected
        Memory expectedMemory = new Memory();
        for(int i = 0; i < 4; i++){
            expectedMemory.increaseCurrentCell();
        }

        while(expectedMemory.getCurrentCell() != 0){

            expectedMemory.pointerMoveForward();
            expectedMemory.increaseCurrentCell();
            expectedMemory.pointerMoveForward();
            expectedMemory.decreaseCurrentCell();
            expectedMemory.decreaseCurrentCell();

            while(expectedMemory.getCurrentCell() != 0){

                expectedMemory.pointerMoveForward();
                expectedMemory.increaseCurrentCell();
                expectedMemory.increaseCurrentCell();
                expectedMemory.increaseCurrentCell();
                expectedMemory.pointerMoveBackward();
                expectedMemory.increaseCurrentCell();
            }
            expectedMemory.pointerMoveBackward();
            expectedMemory.pointerMoveBackward();
            expectedMemory.decreaseCurrentCell();
        }

        expectedMemory.pointerMoveForward();
        expectedMemory.pointerMoveForward();
        expectedMemory.pointerMoveForward();

        assertTrue(expectedMemory.equals(returnedMemory));
    }

}