package utils;

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
        validateForInvalidAccessIndex(index);

        // RETURN element at index
        return data[index];
    }

    private void validateForInvalidAccessIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside boundaries of data in list");
        }
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

    private static void validateForNull(String element) {
        if(element == null){
            throw new IllegalArgumentException("List does not support null objects");
        }
    }


    public void add(String element){
        // VALIDATE FOR REAL:
        validateForNull(element);

        // CONFIRM SPACE AVAILABILITY
        if(size == data.length){
            // IF NOT, ADD MORE SLOTS TO INTERNAL ARRAY
            grow();
        }

        // ADD NEW ELEMENT AT END OF DATA SET
        data[size] = element;
        // UPDATE SIZE COUNT - INCREASE BY ONE
        size++;
    }

    private void grow(){
        String [] newArray = new String[data.length * EXPANSION_FACTOR];

        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    // todo: remove() - remove from position
    public String remove(int index){
        // Validate position to confirm it exists
        validateForInvalidAccessIndex(index);

        // Store element to be deleted
        String deletedElement = data[index];

        // Shift delete element
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        // Wipe duplicate from end of list
        data[size-1] = null;

        // Change size as we deleted an element
        size--;

        // Return deleted element back to calling code
        return deletedElement;
    }

    // todo: remove() - remove first instance
    // todo: removeAll() - remove all instances
    public void clear(){
        // Create new blank array with default settings
        String [] blank = new String[INITIAL_CAPACITY];
        // Replace original data array
        data = blank;
        // Reset metadata
        size = 0;
    }
}
