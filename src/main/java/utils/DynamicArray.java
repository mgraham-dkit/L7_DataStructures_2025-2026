package utils;

public class DynamicArray {
    private static final int INITIAL_CAPACITY = 10;

    private String [] data;
    private int size;

    public DynamicArray(){
        data = new String[INITIAL_CAPACITY];
        size = 0;

        bootstrap();
    }

    private void bootstrap(){
        for (int i = 0; i < 5; i++) {
            data[i] = "Hello "+ i;
            size++;
        }
    }

    public int getSize(){
        return size;
    }

    /**
     * Returns the element at the specified position.
     *
     * @param index the position to retrieve element at
     * @return the element at the specified position/index
     * @throws IndexOutOfBoundsException if the specified position is < 0 or >= size of list
     */
    public String get(int index){
        // VALIDATE index
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside boundaries of data in list");
        }

        // RETURN element at index
        return data[index];
    }

    // todo: add() - shift insert
    // todo: resize()/grow()
    // todo: remove() - shift delete
    // todo: contains() - linear search
    public boolean contains(String target){
        // VALIDATE FOR REAL:
        // If target is null:
            // throw Illegal Argument Exception

        // for each element in data from 0 to size:
            // if current element equals target:
                // return true

        // return false
        throw new UnsupportedOperationException("DELETE THIS WHEN YOU WRITE THE REAL CODE!");
    }
}
