package shells;

public class DynamicArray_Shell {
    // todo: create a SHARED/STATIC variable to specify how big the internal array should be
    // private static final int INITIAL_CAPACITY...
    // todo: create a SHARED/STATIC variable to specify how much to grow the internal array by
    // private static final int EXPANSION_FACTOR...

    private String [] data;
    private int size;

    public DynamicArray_Shell(){
        // todo: specify what size array to build
        // data = new String[????];
        size = 0;

        // Populate with dummy data for testing purposes
        bootstrap();
    }

    private void bootstrap(){
        for (int i = 0; i < 5; i++) {
            data[i] = "Hello "+ i;
            size++;
        }
    }

    /**
     * Returns the size of the list.
     * @return The number of elements currently stored in the list
     */
    public int size(){
        // todo: Add code to return the number of elements currently in the list
        throw new UnsupportedOperationException("Remove this line after you finish the method's logic!");
    }

    /**
     * Returns the element at the specified index/position in the list
     * @param index The index/position from which to get element
     * @return Element at specified index/position
     * @throws IndexOutOfBoundsException if specified index/position is outside bounds of list data
     */
    public String get(int index){
        // Validate for good data - Confirm the supplied position/index is valid to access
        validateIndexForAccess(index);

        // todo: Add code to return the element at the specified index
        // return ....
        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    /**
     * Validate a given index to check if it's within the boundaries of the data in the array.
     * (Note: As the internal array may not be full, the boundary is based on the number of elements currently in the
     * list)
     * @param index Index/position to validate as existing within this list
     * @throws IndexOutOfBoundsException if supplied index is < 0 or >= size of list
     */
    private void validateIndexForAccess(int index){
        // todo: Update the below condition to check if the position/index requested is after the end of the data
        // Remember, the length of the array is not always the end of the data - the array might not be full!
        if(index < 0){
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside bounds of list");
        }
    }

    /**
     * Replaces the internal array with a bigger version if it's full.
     */
    private void ensureCapacity(){
        // If the internal array is full
        if(size == data.length){
            // todo: Create a new array based on size of internal array * expansion factor
            // todo: Copy all elements from internal array to new array
            // todo: Replace internal array with new array (data = new array)
        }
    }

    /**
     * Validate a given String to check if it's null
     * @param element the String to be checked
     * @throws IllegalArgumentException if supplied String is null
     */
    private void validateForNull(String element){
        // todo: Check if supplied String is null
        // If it is, throw an exception (see JavaDoc for which type!)
    }

    /**
     * Adds a supplied element to the end of the list.
     * If internal array is full, it will be replaced with a larger version
     * to facilitate adding new element. Null elements are not permitted.
     *
     * @param element The new element to be added to the end of the list.
     * @throws IllegalArgumentException if the supplied element is null.
     */
    public void add(String element){
        // todo: Validate element to make sure it's not null

        // Make sure there's space to add new element
        ensureCapacity();

        // todo: Insert element at position/index after data ends
        //  (remember that position of last element in list is size-1)

        // todo: Increase number of elements in list
    }

    /**
     * Gets the position of the first instance of a supplied element in the list.
     * This performs a case-insensitive linear search. Search for null is not permitted.
     *
     * @param element The element to be found in the list
     * @return the index of the first matching instance found in the list, or -1 if no match is found
     * @throws IllegalArgumentException if element to be found is null
     */
    public int indexOf(String element){
        validateForNull(element);

        // todo: Linear search through internal array (from 0 to end of DATA, not end of array)
            // Check if current element matches supplied element (case-insensitive)
            // If a match is found, return its position immediately

        // If no match is found by end of data, return -1

        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    public void add(int index, String element){
        // todo: Validate element to confirm it's not null

        // todo: Validate index to confirm it's within boundaries -
        //      remember that the validation for adding is not quite the same as the
        //      validation for getting!

        // todo: make sure there's enough space for the new element

        // todo: shift everything in array up by one space,
        //  - start at the end of the *data* (not the array!), work towards specified index

        // todo: add element into array at specified position

        // todo: Increase size of list by 1
    }

    /**
     * Checks if a supplied element is present within the list (case-insensitive). Search for null is not permitted.
     * @param element The element to be found within the list.
     * @return True if the element is located anywhere within the list, false otherwise.
     * @throws IllegalArgumentException if supplied element is null
     */
    public boolean contains(String element){
        // todo: Complete logic
            // todo: Validate for null (throw exception if its null)
            // todo: Search for match
            // todo: Return verdict

        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    // Extra methods to attempt if you're bored!
    // todo: set - replace the element at a specified index with a supplied element. Should return replaced/lost element
    // todo: clear - delete all elements in the list (resets list to empty)
    // todo: isEmpty - check if the list is empty (true/false)
    // todo: toArray - create and return a *new* array containing the list's data
}
