package compiler;

import java.util.Scanner;

public class InputDelegator {

    /**
     * Delegate input
     * /
     * @return input string
     */
    public String getInputString(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"code\"");

        String sourceCode = scanner.nextLine();
        return sourceCode;
    }
}
