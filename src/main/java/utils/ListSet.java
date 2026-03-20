package utils;

public class ListSet {
    private LinkedList list;

    public ListSet(){
        this.list = new LinkedList();
    }

    public int getSize(){
        return list.getSize();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int indexOf(String element){
        return list.indexOf(element);
    }

    public boolean contains(String element){
        return list.contains(element);
    }

    public String get(int index){
        return list.get(index);
    }

    public void clear(){
        list.clear();
    }

    public String remove(int index){
        return list.remove(index);
    }

    public boolean remove(String element){
        return list.remove(element);
    }

    public boolean add(String element){
        if(!list.contains(element)){
            return false;
        }

        list.add(element);
        return true;
    }

    // todo: Implement custom addInclusive
    // todo: Implement custom set
    // todo: Implement any other add-style methods currently in list!
}
