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

        //ready strings to try
        String helloWorldString = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        String zeroToNineString = "++++++[>++++++++<-]>.+.+.+.+.+.+.+.+.+.";
        String myInstagram = "++++++++[>++++<-]>[>+>++<<-]>>[>+>+<<-]<<<+++++[>++++++++<-]>[->>+>>+<<<<]>>>>+.+++++.+++++.+.<------.<<.>>++++++.>-------.[>+>+<<-]>>------------.<--.++++++++.";

        String moveString = "[>+<-]";
        String copyString = "[>+>+<<-]";
        String doubleString = ">[>+>++<<-]";

        Compiler processor = new Compiler();
        processor.compile();

    }
}
