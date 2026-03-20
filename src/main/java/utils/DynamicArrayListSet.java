package utils;

public class DynamicArrayListSet extends DynamicArray{
    public boolean addDistinct(String element){
        if(super.contains(element)){
            return false;
        }

        super.add(element);
        return true;
    }

    @Override
    public void add(String element){
        addDistinct(element);
    }
}
