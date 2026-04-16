package utils;

public class PriorityQueue {
    private int size;
    private Node first;
    private Node last;

    public PriorityQueue(){

    }

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public int count(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public String peek(){
        if(isEmpty()){
            throw new IllegalStateException("Cannot peek at an empty queue");
        }

        return first.data;
    }

    public void enqueue(String element){
        if(element == null){
            throw new IllegalArgumentException("Cannot add a null element to the queue");
        }

        Node newNode = new Node(element);

        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else if(first.data.compareToIgnoreCase(element) > 0){
            newNode.next = first;
            first = newNode;
        }else if(last.data.compareToIgnoreCase(element) <= 0){
            last.next = newNode;
            last = newNode;
        }else{
            Node prev = null;
            Node current = first;
            for (int i = 0; i < size; i++) {
                if(current.data.compareToIgnoreCase(element) > 0){
                    break;
                }
                prev = current;
                current = current.next;
            }

            prev.next = newNode;
            newNode.next = current;
        }

        size++;
    }

    public String dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Cannot remove from an empty queue");
        }

        String removed = first.data;

        first = first.next;
        size--;

        if(size == 0){
            last = first;
        }

        return removed;
    }
}
