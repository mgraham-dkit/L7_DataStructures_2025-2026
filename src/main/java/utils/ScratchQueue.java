package utils;

public class ScratchQueue {
    private int size;
    private Node first;
    private Node last;

    public ScratchQueue(){

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
        }else {
            last.next = newNode;
        }
        last = newNode;

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
