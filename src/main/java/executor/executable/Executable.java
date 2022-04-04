package executor.executable;

import executor.Memory;

/**
 * Defines objects-methods which can execute
 * operate memory
 * /
 * Command pattern is used
 * /
 * Can be blocks of instructions or instructions
 */
public interface Executable {

    void execute(Memory memory);

}
