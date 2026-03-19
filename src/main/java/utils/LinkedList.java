package utils;

public class LinkedList {
    private int size;
    private Node first;
    private Node last;

    public LinkedList(){
        clear();
    }

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(String element){
        validateForNullElement(element);

        Node newNode = new Node(element);
        if(first == null){
            first = newNode;
        }else{
            last.next = newNode;
        }

        last = newNode;
        size++;
    }

    private static void validateForNullElement(String element) {
        if(element == null){
            throw new IllegalArgumentException("Cannot add null to list");
        }
    }

    public String getFirst(){
        if(isEmpty()){
            return null;
        }
        return first.data;
    }

    public String getLast(){
        if(isEmpty()){
            return null;
        }
        return last.data;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
    }

    public String get(int index){
        validateIndexOutOfBounds(index);

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    private void validateIndexOutOfBounds(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Supplied index outside bounds of list - was " + index + ", list ends" +
                    " " +
                    "at " + (size-1));
        }
    }

    public void add(int index, String element){
        // VALIDATION
        // Validate element to confirm good AND real data : validateForNull
        validateForNullElement(element);
        // Validate index to confirm position is within list : validateIndexOutOfBounds
        validateIndexOutOfBounds(index);

        if(index == 0){
            Node newNode = new Node(element);
            newNode.next = first;
            first = newNode;
        }else {
            Node newNode = new Node(element);

            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Validate a given index to check if it's within the boundaries of the data in the list (0 - size inclusive).

     * @param index Index/position to validate as existing within this list
     * @throws IndexOutOfBoundsException if supplied index is < 0 or > size of list
     */
    private void validateIndexOutOfBoundsInclusive(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Supplied index outside bounds of list - was " + index
                    + ", last " + "allowable position to add: " + (size));
        }
    }

    /**
     * Add a new element at a specified position between 0 and size (inclusive).
     * This version of the action allows for adding AFTER the data within the list;
     * it uses the next possible index as its limit
     * @param index The position at which to insert the new element (0-size inclusive)
     * @param element The value to be inserted into the list
     * @throws IllegalArgumentException if the element supplied is null
     * @throws IndexOutOfBoundsException if the index supplied is < 0 or > size of list
     */
    public void addInclusive(int index, String element) {
        // VALIDATION
        // Validate element to confirm good AND real data : validateForNull
        validateForNullElement(element);
        // Validate index to confirm position is within list (adding at end permitted) :
        // validateIndexOutOfBoundsInclusive
        validateIndexOutOfBoundsInclusive(index);

        Node newNode = new Node(element);

        if (size == 0) {            // If the list is empty
            first = newNode;
            last = newNode;
        } else if (index == 0) {    // If it's being added to the start
            newNode.next = first;
            first = newNode;
        } else if (index == size){  // If it's being added at the end
            last.next = newNode;
            last = newNode;
        }else {                     // If it's being added anywhere else in between
            Node current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        // Element added, increase size metadata
        size++;
    }

    public String remove(int index){
        validateIndexOutOfBounds(index);

        String removed = null;
        if(index == 0){
            removed = first.data;
            if(first == last){
                last = null;
            }
            first = first.next;
        }else{
            Node current = first;
            Node prev = null;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }
            removed = current.data;
            prev.next=current.next;

            if(index == size-1){
                last = prev;
            }
        }

        size--;
        return removed;
    }

    public boolean remove(String element){
        validateForNullElement(element);

        // Handle empty list
        if(isEmpty()){
            return false;
        }
        // Handle deleting from start of list
        if(first.data.equalsIgnoreCase(element)){
            // Handle list of one
            if(first == last){
                last = null;
            }
            first = first.next;
            size--;
            return true;
        }

        Node current = first;
        Node prev = null;

        for (int i = 0; i < size; i++) {
            // Detect a match in remainder of list
            if(current.data.equalsIgnoreCase(element)) {
                // Delete element
                prev.next=current.next;

                // Handle deleting from end
                if(i == size-1) {
                    last = prev;
                }

                // Decrease size
                size--;
                // Return that value was deleted
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int indexOf(String element){
        validateForNullElement(element);

        Node current = first;
        for(int i = 0; i < size; i++){
            if(element.equalsIgnoreCase(current.data)){
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    public int lastIndexOf(String element){
        validateForNullElement(element);

        int index = -1;

        Node current = first;
        for(int i = 0; i < size; i++){
            if(element.equalsIgnoreCase(current.data)){
                index = i;
            }
            current = current.next;
        }

        return index;
    }

    public boolean contains(String target){
        validateForNullElement(target);

        return indexOf(target) != -1;
    }


    public String set(int index, String value){
        validateIndexOutOfBounds(index);
        validateForNullElement(value);

        // Loop to specified position (where we want to replace data)
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Save old version that is being replaced
        String replaced = current.data;

        // Replace data with new value
        current.data = value;

        // return replaced information
        return replaced;
    }

    public void clear(){
        first = null;
        last = null;
        size = 0;
    }


    public String[] toArray(){
        // Create new array of same size as list
        String [] listArray = new String[size];
        // for each node in list
        Node current = first;
        for (int i = 0; i < size ; i++) {
            // Copy data from within current node into array at same position
            listArray[i] = current.data;
            current = current.next;
        }

        // Return array
        return listArray;
    }

    public void addAll(String [] values){
        if(values == null){
            throw new IllegalArgumentException("Array of values cannot be null");
        }

        // Loop through all values in the string array
        for (int i = 0; i < values.length; i++) {

            // Add each one that is not null into the current list
            add(values[i]);
        }
    }

    public LinkedList getSublist(int startIndex, int endIndex){
        // Return a new LinkedList made up of all elements between startIndex and endIndex (exclusive)
        throw new UnsupportedOperationException("Not done yet!");
    }
}
