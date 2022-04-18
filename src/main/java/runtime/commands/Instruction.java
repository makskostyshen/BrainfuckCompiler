package runtime.commands;

/**
 * Simple instruction
 * can be executed with memory
 */
public abstract class Instruction implements Command {

    @Override
    public boolean equals(Object other){
        return this.getClass() == other.getClass();
    }

}
