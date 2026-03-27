package utils;

import java.util.EmptyStackException;

public class Stack {
    private final LinkedList data;

    public Stack(){
        data = new LinkedList();
    }

    public String pop(){
        validateOccupancy();

        return data.remove(0);
    }

    private void validateOccupancy() {
        if(data.isEmpty()){
            throw new EmptyStackException();
        }
    }

    public String peek(){
        validateOccupancy();

        return data.get(0);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int count(){
        return data.getSize();
    }

    public void push(String element){
        data.add(element);
    }
}
