package utils;

public class DynamicArray {
    private static final int INITIAL_CAPACITY = 10;

    private String [] data;
    private int size;

    public DynamicArray(){
        data = new String[INITIAL_CAPACITY];
        size = 0;
    }

    public int getSize(){
        return size;
    }

    // todo: add() - shift insert
    // todo: resize()/grow()
    // todo: remove() - shift delete
    // todo: get() - like overwrite, but return instead of replace
    // todo: contains() - linear search
}
