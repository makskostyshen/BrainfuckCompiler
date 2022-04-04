package interpreter;

import exceptions.BracketsException;
import executor.executable.blocks.Block;
import executor.executable.blocks.Cycle;
import executor.executable.instructions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockCreatorTest {

    @Test
    void noInputIsEmptyBlock(){

        //returned
        BlockCreator creator = new BlockCreator();
        Block returnedBlock = creator.getCreatedExternalBlock();

        //expected
        Block expectedBlock = new Block();

        assert(returnedBlock.equals(expectedBlock));
    }

    @Test
    void AllSimpleOperationsAreCorrect(){

        //returned
        BlockCreator creator = new BlockCreator();
        creator.addInstruction(new IncreaseCellValue());
        creator.addInstruction(new DecreaseCellValue());
        creator.addInstruction(new PrintCell());
        creator.addInstruction(new DecreaseCellValue());
        creator.addInstruction(new NextCell());
        creator.addInstruction(new PreviousCell());
        Block returnedBlock = creator.getCreatedExternalBlock();

        //expected
        Block expectedBlock = new Block();
        expectedBlock.add(new IncreaseCellValue());
        expectedBlock.add(new DecreaseCellValue());
        expectedBlock.add(new PrintCell());
        expectedBlock.add(new DecreaseCellValue());
        expectedBlock.add(new NextCell());
        expectedBlock.add(new PreviousCell());

        assert(returnedBlock.equals(expectedBlock));
    }


    @Test
    void OneSimpleBracketAreCorrect(){
        //returned
        BlockCreator creator = new BlockCreator();
        creator.addInstruction(new IncreaseCellValue());
        creator.openCycle();
        creator.addInstruction(new PrintCell());
        creator.closeCycle();
        creator.addInstruction(new DecreaseCellValue());
        Block returnedBlock = creator.getCreatedExternalBlock();


        //expected
        Cycle innerCycle = new Cycle();
        innerCycle.add(new PrintCell());

        Block expectedBlock = new Block();
        expectedBlock.add(new IncreaseCellValue());
        expectedBlock.add(innerCycle);
        expectedBlock.add(new DecreaseCellValue());


        assert(returnedBlock.equals(expectedBlock));
    }

    @Test
    void TwoSimpleBracketsAreCorrect(){
        //returned
        BlockCreator creator = new BlockCreator();

        creator.addInstruction(new IncreaseCellValue());
        creator.openCycle();
        creator.addInstruction(new NextCell());
        creator.closeCycle();
        creator.addInstruction(new DecreaseCellValue());
        creator.openCycle();
        creator.addInstruction(new IncreaseCellValue());
        creator.closeCycle();

        Block returnedBlock = creator.getCreatedExternalBlock();

        //expected
        Cycle innerCycle1 = new Cycle();
        innerCycle1.add(new NextCell());

        Cycle innerCycle2 = new Cycle();
        innerCycle2.add(new IncreaseCellValue());

        Block expectedBlock = new Block();
        expectedBlock.add(new IncreaseCellValue());
        expectedBlock.add(innerCycle1);
        expectedBlock.add(new DecreaseCellValue());
        expectedBlock.add(innerCycle2);

        assert(returnedBlock.equals(expectedBlock));
    }

    @Test
    void EmptyBracketsAreCorrect(){
        //returned
        BlockCreator creator = new BlockCreator();

        creator.openCycle();
        creator.closeCycle();
        creator.addInstruction(new DecreaseCellValue());
        creator.openCycle();
        creator.closeCycle();

        Block returnedBlock = creator.getCreatedExternalBlock();

        //expected
        Cycle innerCycle1 = new Cycle();

        Cycle innerCycle2 = new Cycle();

        Block expectedBlock = new Block();
        expectedBlock.add(innerCycle1);
        expectedBlock.add(new DecreaseCellValue());
        expectedBlock.add(innerCycle2);

        assert(returnedBlock.equals(expectedBlock));
    }

    @Test
    void InnerInnerBracketsAreCorrect(){
        //returned
        BlockCreator creator = new BlockCreator();

        creator.openCycle();
        creator.addInstruction(new DecreaseCellValue());
        creator.openCycle();
        creator.addInstruction(new DecreaseCellValue());
        creator.closeCycle();
        creator.addInstruction(new DecreaseCellValue());
        creator.closeCycle();
        creator.addInstruction(new DecreaseCellValue());

        Block returnedBlock = creator.getCreatedExternalBlock();

        //expected

        Cycle innerInnerCycle = new Cycle();
        innerInnerCycle.add(new DecreaseCellValue());

        Cycle innerCycle = new Cycle();
        innerCycle.add(new DecreaseCellValue());
        innerCycle.add(innerInnerCycle);
        innerCycle.add(new DecreaseCellValue());

        Block expectedBlock = new Block();
        expectedBlock.add(innerCycle);
        expectedBlock.add(new DecreaseCellValue());

        assert(returnedBlock.equals(expectedBlock));
    }

    @Test
    void CloseBracketBeforeOpenIsError(){
        //expected error
        BlockCreator creator = new BlockCreator();
        assertThrows(BracketsException.class,
                () -> {creator.closeCycle();});
    }

    @Test
    void OpenedBracketReturnIsError(){

        //expected error
        BlockCreator creator = new BlockCreator();
        creator.openCycle();
        assertThrows(BracketsException.class,
                () -> {creator.getCreatedExternalBlock();});
    }

    @Test
    void EmptyCycleIsNotNothing(){

        //returned
        BlockCreator creator = new BlockCreator();
        creator.openCycle();
        creator.closeCycle();
        Block returnedBlock = creator.getCreatedExternalBlock();

        Block expectedBlock = new Block();
        assertFalse(returnedBlock == expectedBlock);
    }


}