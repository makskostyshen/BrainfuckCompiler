package executor.executable.instructions;

import executor.executable.Executable;

/**
 * Simple instruction
 * can be executed with memory
 */
public abstract class Instruction implements Executable {

    @Override
    public boolean equals(Object other){
        return this.getClass() == other.getClass();
    }

}
