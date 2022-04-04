package interpreter;

import interpreter.commands.SynthesizingCommand;
import exceptions.BracketsException;
import executor.executable.blocks.Block;

/**
 * Interprets string of "brainfuck code" to
 * intuitively understandable block of instructions
 */

public class Interpreter {

    private String sourceCode; //what was inputted
    private BlockCreator blockCreator;

    public Interpreter(String sourceCode){
        this.sourceCode = sourceCode;
        blockCreator = new BlockCreator();
    }


    public Block interpret() throws BracketsException{

        Block block = new Block();

        try{
            block = getSynthesizedBlock();
        }
        catch (BracketsException be){
            throw new BracketsException("wrong input, problem with cycle brackets occurred");
        }
        return block;
    }

    /**
     * Make interpretation
     * /
     * @return block of instructions
     * @throws BracketsException if sourceCode has wrong cycles
     */

    private Block getSynthesizedBlock() throws BracketsException{

        for(int pointer = 0; pointer < sourceCode.length(); pointer++){

            char sourceSymbol = sourceCode.charAt(pointer);

            // command used to operate block creator
            SynthesizingCommand currentCommand
                    = SymbolConverter.getSynthesizingCommand(sourceSymbol);

            if(currentCommand != null){
                currentCommand.synthesize(blockCreator);
            }
        }

        return blockCreator.getCreatedExternalBlock();
    }

}
