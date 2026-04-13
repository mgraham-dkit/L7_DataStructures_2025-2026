package utils;

/**
 * Composition-based approach to developing a QueueSet data structure
 * This is a form of Queue (add at the end, remove from the start) where
 * duplicates are not permitted (Sets do not allow duplicates)
 */
public class QueueSet {
    private final LinkedList list;

    public QueueSet(){
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

    public boolean enqueue(String element){
        if(element == null){
            throw new IllegalArgumentException("Cannot add a null element to the queue");
        }

        if(list.contains(element)){
            return false;
        }
        
        list.add(element);
        return true;
    }
}
