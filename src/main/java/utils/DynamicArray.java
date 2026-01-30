package utils;

import com.sun.nio.sctp.PeerAddressChangeNotification;

public class DynamicArray {
    private static final int INITIAL_CAPACITY = 10;
    private static final int EXPANSION_FACTOR = 2;

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

    public boolean contains(String target){
        int index = indexOf(target);
        if(index != -1){
            return true;
        }else{
            return false;
        }
        // return indexOf(target) != -1;
    }

    public int indexOf(String target){
        // VALIDATE FOR REAL:
        validateForNull(target);

        for (int i = 0; i < size; i++) {
            if(data[i].equalsIgnoreCase(target)){
                return i;
            }
        }

        return -1;
    }


    // todo: add() - shift insert
    // todo: resize()/grow()
    // todo: remove() - shift delete

    private static void validateForNull(String element) {
        if(element == null){
            throw new IllegalArgumentException("List does not support null objects");
        }
    }
}
