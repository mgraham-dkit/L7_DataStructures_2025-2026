package utils;

public class LinkedList {
    private int size;
    private Node first;
    private Node last;

    public LinkedList(){
        first = null;
        last = null;
        size = 0;
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

    // todo: indexOf() - takes in value to be located, returns position of first instance
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

    // todo: lastIndexOf()
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

    // todo: contains()

    // todo: set()
    // todo: clear()
    // todo: toArray()
}
