package utils;

/**
 * Composition-based approach to developing a Queue data structure.
 * A Queue is a form of data structure where data is only ever added at the end,
 * and is only ever retrieved or removed from the start.
 * Queues are a more specific version of Lists.
 */
public class Queue {
    private final LinkedList list;

    public Queue(){
        this.list = new LinkedList();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int count(){
        return list.getSize();
    }

    public String peek(){
        if(list.isEmpty()){
            throw new IllegalStateException("Cannot retrieve from an empty Queue");
        }

        return list.get(0);
    }

    public String dequeue(){
        if(list.isEmpty()){
            throw new IllegalStateException("Cannot remove from an empty Queue");
        }

        return list.remove(0);
    }

    public void enqueue(String element){
        if(element == null){
            throw new IllegalArgumentException("Cannot add a null element to the queue");
        }

        list.add(element);
    }
}
