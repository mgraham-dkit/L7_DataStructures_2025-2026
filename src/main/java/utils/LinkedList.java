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
    }


    // todo: indexOf() - takes in value to be located, returns position of first instance
    // todo: set()
    // todo: contains()
    // todo: clear()
    // todo: toArray()
}
