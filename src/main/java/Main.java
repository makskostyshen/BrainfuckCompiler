import runtime.Executor;
import runtime.commands.Command;

import java.util.List;

/**
 * Brainfuck compiler program
 * /
 * To compile - run and follow instructions
 * /
 *
 * @author - Maks Kostyshen
 */
public class Main {

    public static void main(String[] args) {

        //ready strings to try
        String helloWorldString = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]" +
                ">>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

        compiler.Compiler compiler = new compiler.Compiler(helloWorldString);
        List<Command> executables = compiler.compile();

        Executor executor = new Executor();
        executor.execute(executables);
    }
}
