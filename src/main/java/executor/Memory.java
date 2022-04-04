package executor;


import java.util.Arrays;

/**
 * Imitates simple computer memory
 */
public class Memory {
    private byte[] cells;
    private int pointer;
    private static final int capacity = 30000; //max number of cells

    public Memory(){
        cells = new byte[capacity];
        pointer = 0;
    }

    public void pointerMoveForward(){
        if(pointer < capacity-1){
            pointer++;
        }
        else{
            pointer = 0;
        }
    }

    public void pointerMoveBackward(){
        if(pointer > 0){
            pointer--;
        }
        else{
            pointer = capacity-1;
        }
    }

    public void decreaseCurrentCell(){
        cells[pointer]--;
    }

    public void increaseCurrentCell(){
        cells[pointer]++;
    }

    public byte getCurrentCell(){
        return cells[pointer];
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Memory)){
            return false;
        }
        Memory otherMemory = (Memory) other;

        return (pointer == otherMemory.pointer)
                && (Arrays.equals(otherMemory.cells, cells));
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < 5; i++){
            b.append(cells[i]);
        }
        return b.toString();
    }

}
