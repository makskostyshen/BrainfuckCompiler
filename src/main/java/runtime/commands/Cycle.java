package runtime.commands;

import runtime.Memory;

import java.util.ArrayList;
import java.util.List;

public class Cycle implements Command {

    private final List<Command> innerCycleCommands;

    public Cycle(List<Command> innerCycleCommands) {

        this.innerCycleCommands = new ArrayList<>(innerCycleCommands);
    }

    @Override
    public void execute(Memory memory) {

        while (memory.getCurrentCell() != 0) {

            innerCycleCommands.forEach(command -> command.execute(memory));
        }
    }

    @Override
    public String toString() {
        return "Cycle " + innerCycleCommands;
    }
}
