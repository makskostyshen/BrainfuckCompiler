package runtime;


import java.util.Arrays;

/**
 * Imitates simple computer memory
 */
public class Memory {

    private static final int MEMORY_SIZE = 30000; //max number of cells

    private byte[] cells = new byte[MEMORY_SIZE];
    private int pointer;

    public void pointerMoveForward() {
        if (pointer < MEMORY_SIZE - 1) {
            pointer++;
        } else {
            pointer = 0;
        }
    }

    public void pointerMoveBackward() {
        if (pointer > 0) {
            pointer--;
        } else {
            pointer = MEMORY_SIZE - 1;
        }
    }

    public void decreaseCurrentCell() {
        cells[pointer]--;
    }

    public void increaseCurrentCell() {
        cells[pointer]++;
    }

    public byte getCurrentCell() {
        return cells[pointer];
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Memory)) {
            return false;
        }
        Memory otherMemory = (Memory) other;

        return (pointer == otherMemory.pointer)
                && (Arrays.equals(otherMemory.cells, cells));
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(pointer + ": ");
        for (int i = 0; i < 15; i++) {
            b.append(cells[i] + " ");
        }
        return b.toString();
    }

}
