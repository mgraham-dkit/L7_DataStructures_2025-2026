package shells;

public class LinkedList_Shell {
    // todo: create a variable to track the first element in the list (this should be stored in a Node)
    // todo: create a variable to track the last element in the list (stored in a Node)
    private int size;

    public LinkedList_Shell(){
        // todo: set the first and last elements to be empty/null
        size = 0;
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
        // Validate for good data - Confirm the supplied position/index is valid to _access_
        validateIndexForAccess(index);

        // todo: Create a Node pointing to the start of the list (current)
        // todo: For each position starting at the start up to the specified index
        // todo: Set current to current.next (move on to the next element in the list)
        // todo: Return the data stored inside the Node at that index
        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    /**
     * Validate a given index to check if it's within the boundaries of the data in the list.

     * @param index Index/position to validate as existing within this list
     * @throws IndexOutOfBoundsException if supplied index is < 0 or >= size of list
     */
    private void validateIndexForAccess(int index){
        // todo: Update the below condition to check if the position/index requested is after the end of the data
        if(index < 0){
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside bounds of list");
        }
    }

    /**
     * Validate a given index to check if it's within the boundaries of the data in the list (0 - size inclusive).

     * @param index Index/position to validate as existing within this list
     * @throws IndexOutOfBoundsException if supplied index is < 0 or > size of list
     */
    private void validateIndexForAdd(int index){
        // todo: Update the below condition to check if the position/index requested is after the end of the data
        if(index < 0){
            throw new IndexOutOfBoundsException("Supplied index (" + index + ") is outside bounds of list");
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
     * Null elements are not permitted.
     *
     * @param element The new element to be added to the end of the list.
     * @throws IllegalArgumentException if the supplied element is null.
     */
    public void add(String element){
        // todo: Validate element to make sure it's not null

        // todo: Wrap element in Node object

        // todo: Check if list is currently empty
        // todo: If list is empty, set first to new Node
        // todo: If list is not empty, set last.next to new Node

        // todo: Set new Node to be the last element in the list

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

        // todo: Linear search through list by moving through nodes
        // todo: Create Node to use to move through the list (current) and set to first
        // todo: For each position (i) from 0 to size:
            // todo: if data inside current node matches supplied element (case-insensitive), return i

        // todo: If no match is found by end of data, return -1

        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    public void add(int index, String element){
        // todo: Validate element to confirm it's not null

        // todo: Validate index to confirm it's within boundaries -
        //      remember that the validation for adding is not quite the same as the
        //      validation for getting!

        // todo: Check if list is empty (handle adding to empty list):
            // todo: Set first and last to new Node
        // todo: Check if index is 0 (handle adding at start of list)
            // todo: Make newNode point to first (set newNode.next to first)
            // todo: Make newNode the first element (set first to newNode)
        // todo: Check if index equals size (handle adding at end of list)
            // todo: Make last element point to new node (set last.next to newNode)
            // todo: Make newNode the last element (set last to newNode)
        // todo: Handle adding to middle:
            // todo: Create node to use to move through list (current) and start it at first
            // todo: For each position in list up to index-1 (do NOT go as far as index!)
                // todo: Move current to next position (set current to current.next)
            // todo: Make newNode point to the same thing as the current node (set newNode.next equal to current.next)
            // todo: Make current point to the new Node (set current.next equal to newNode)

        // todo: Increase size of list by 1
    }

    /**
     * Checks if a supplied element is present within the list (case-insensitive).
     * Search for null is not permitted.
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

    /**
     * Removes the element found at the specified position
     * @param index The index/position from which to remove/delete the data
     * @return The element removed from the specified position
     * @throws IndexOutOfBoundsException where the supplied index is outside the boundaries of the data in the list
     */
    public String remove(int index){
        // Steps to be inserted!
        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    /**
     * Removes the first instance of the specified element (search is case-insensitive)
     * @param element The element to be removed/deleted from the list
     * @return True if the element was deleted, false if it could not be found
     * @throws IllegalArgumentException where the element supplied is null.
     */
    public boolean remove(String element){
        // Steps to be inserted!
        throw new UnsupportedOperationException("Remove this line after you finish the method logic!");
    }

    // Extra methods to attempt if you're bored!
    // todo: set - replace the element at a specified index with a supplied element. Should return replaced/lost element
    // todo: clear - delete all elements in the list (resets list to empty)
    // todo: isEmpty - check if the list is empty (true/false)
    // todo: toArray - create and return a new array containing the list's data
}
