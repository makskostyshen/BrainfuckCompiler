package runtime.commands;

import runtime.Memory;

/**
 * Defines objects-methods which can execute
 * operate memory
 * /
 * Command pattern is used
 * /
 * Can be blocks of instructions or instructions
 */
public interface Command {

    void execute(Memory memory);

}
