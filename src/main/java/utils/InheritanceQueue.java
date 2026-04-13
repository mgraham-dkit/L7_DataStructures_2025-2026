package utils;

public class InheritanceQueue extends DynamicArray{
    public InheritanceQueue(){

    }

    // isEmpty() - takes no parameters, returns a boolean [DOES NOT EXIST IN SUPER]
    // count() - takes no parameters, returns an int [getSize() IN SUPER]
    // enqueue() - takes the element to be added, returns nothing [ add() and add(index) IN SUPER]
    // dequeue() - takes no parameters, removes and returns element in starting/initial position of
    // queue [remove (element) and remove(position) IN SUPER]
    // peek() - takes no parameters, returns element in starting/initial position of queue [get(position) IN SUPER]

    // EXTRAS -> clear(), indexOf(), contains()

    // What do I need to build?
    // - isEmpty()
    public boolean isEmpty(){
        return super.getSize() == 0;
    }

    // What do I need to change?
    // - getSize() needs to be renamed to count()

    public int count(){
        return super.getSize();
    }

    // - add() needs to be renamed to enqueue()
    public void enqueue(String element){
        if(element == null){
            throw new IllegalArgumentException("Null element cannot be added to queue");
        }
        super.add(element);
    }

    // - add(index) needs to be blocked
    public void add(int index, String element){
        throw new UnsupportedOperationException("Cannot add to a specific position in a Queue");
    }

    // - remove(index) needs to not have a parameter, and needs to be renamed to dequeue()
    public String dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Cannot remove from an empty Queue");
        }

        return super.remove(0);
    }

    public String remove(int index){
        throw new UnsupportedOperationException("Cannot remove from a specific position in a Queue");
    }

    // - remove(element) needs to be blocked
    public boolean remove(String element){
        throw new UnsupportedOperationException("Cannot remove a specified element from a Queue");
    }

    // - get(index) needs to not have a parameter and needs to be renamed to peek()
    public String peek(){
        if(isEmpty()){
            throw new IllegalStateException("Cannot retrieve from an empty Queue");
        }

        return super.get(0);
    }

    public String get(int index){
        throw new UnsupportedOperationException("Cannot access any specific position in a Queue");
    }

    // Which are safe to keep?
    // - clear() - no action required

    // Which should be blocked?
    // - indexOf()
    public int indexOf(String element){
        throw new UnsupportedOperationException("Cannot search a Queue");
    }
    // - contains()
    public boolean contains(String element){
        throw new UnsupportedOperationException("Cannot search a Queue");
    }
}
