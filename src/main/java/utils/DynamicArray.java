package utils;

public class DynamicArray {
    private static final int INITIAL_CAPACITY = 10;
    private static final int EXPANSION_FACTOR = 2;

    private String [] data;
    private int size;

    public DynamicArray(){
        data = new String[INITIAL_CAPACITY];
        size = 0;
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
        // Alternative approach:
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

    /**
     * Replaces the internal array with a bigger version if it's full.
     */
    private void ensureCapacity(){
        // If the internal array is full
        if(size == data.length){
            String [] expanded = new String [data.length * EXPANSION_FACTOR];

            for (int i = 0; i < data.length; i++) {
                expanded[i] = data[i];
            }

            data = expanded;
        }
    }

    public void add(String element){
        // VALIDATE FOR REAL:
        validateForNull(element);

        // CONFIRM SPACE AVAILABILITY
        ensureCapacity();

        // ADD NEW ELEMENT AT END OF DATA SET
        data[size] = element;
        // UPDATE SIZE COUNT - INCREASE BY ONE
        size++;
    }

    public void clear() {
        // Create new blank array with default settings
        String[] blank = new String[INITIAL_CAPACITY];
        // Replace original data array
        data = blank;
        // Reset metadata
        size = 0;
    }

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

    public boolean remove(String target){
        validateForNull(target);

        int index = indexOf(target);
        if(index == -1){
            return false;
        }

        remove(index);
        return true;
    }

    /**
     * Validate a given index to check if it's within the boundaries of the data in the array (including the position
     * after the last element).
     * (Note: As the internal array may not be full, the boundary is based on the number of elements currently in the
     * list)
     * @param index Index/position to validate as existing within this list
     * @throws IndexOutOfBoundsException if supplied index is < 0 or > size of list
     */
    private void validateIndexForAdd(int index){
        // Remember, the length of the array is not always the end of the data - the array might not be full!
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside bounds of list");
        }
    }

    public void add(int index, String element){
        // Validate element to confirm it's not null
        validateForNull(element);

        // Validate index to confirm it's within boundaries -
        //      remember that the validation for adding is not quite the same as the
        //      validation for getting!
        validateIndexForAdd(index);

        // make sure there's enough space for the new element
        ensureCapacity();

        // shift everything in array up by one space,
        //  - start at the end of the *data* (not the array!), work towards specified index
        System.arraycopy(data, index, data, index+1, (size-index));

        // add element into array at specified position
        data[index] = element;

        // Increase size of list by 1
        size++;
    }

    // todo: removeAll() - remove all instances
}
