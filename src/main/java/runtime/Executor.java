package runtime;

import runtime.commands.Command;

import java.util.List;

/**
 * Handles execution of block of instructions with memory
 */
public class Executor {


    public void execute(Iterable<Command> commands) {

        Memory memory = new Memory();
        commands.forEach(command -> command.execute(memory));
    }
}
