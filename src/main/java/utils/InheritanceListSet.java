package utils;

public class InheritanceListSet extends LinkedList{
    public void add(String element){
        validateForNull(element);

        validateForDuplicate(element);

        super.add(element);
    }

    private void validateForDuplicate(String element) {
        if(contains(element)){
            throw new IllegalArgumentException("Cannot add a duplicate element");
        }
    }

    private static void validateForNull(String element) {
        if(element == null){
            throw new IllegalArgumentException("Cannot add null to ListSet");
        }
    }

    public void add(int index, String element){
        validateForNull(element);
        validateForDuplicate(element);

        super.add(index, element);
    }

    public void addInclusive(int index, String element){
        validateForNull(element);
        validateForDuplicate(element);

        super.addInclusive(index, element);
    }

    public String set(int index, String element){
        validateForNull(element);
        validateForDuplicate(element);

        return super.set(index, element);
    }

    public void addAll(String [] elements){
        if(elements == null){
            throw new IllegalArgumentException("Cannot add null array of elements");
        }

        for (String element : elements) {
            if(element == null){
                continue;
            }
            this.add(element);
        }
    }
}
