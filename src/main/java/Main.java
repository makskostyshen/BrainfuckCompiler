import compiler.Compiler;

/**
 * Brainfuck compiler program
 * /
 * To compile - run and follow instructions
 * /
 * @author - Maks Kostyshen
 */

public class Main {

    public static void main(String[] args) {

        //ready string to try
        String helloWorldString = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";


        Compiler processor = new Compiler();
        processor.compile();

    }
}
