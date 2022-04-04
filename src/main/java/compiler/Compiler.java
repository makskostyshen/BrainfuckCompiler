package compiler;

import exceptions.BracketsException;
import executor.Executor;
import executor.executable.blocks.Block;
import interpreter.Interpreter;

public class Compiler {


    /**
     * wrapper method to handle exceptions
     */
    public void compile(){
        try{
            printResult();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }


    /**
     * Proceeds main compilation:
     * /
     * input string, interpret source code and execute it
     * /
     * @throws BracketsException
     */
    private void printResult() throws BracketsException {

        InputDelegator delegator = new InputDelegator();
        String sourceCode = delegator.getInputString();

        Interpreter interpreter = new Interpreter(sourceCode);
        Block block = interpreter.interpret();

        Executor executor = new Executor(block);
        executor.execute();
    }
}
