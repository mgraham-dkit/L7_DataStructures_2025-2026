package utils;

public class SampleIncompleteList implements List{

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public String get(int index) {
        return "";
    }

    @Override
    public int indexOf(String target) {
        return 0;
    }

    @Override
    public void add(String element) {

    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public String remove(int index) {
        return "";
    }

    @Override
    public boolean remove(String target) {
        return false;
    }

    @Override
    public void clear() {

    }
}
