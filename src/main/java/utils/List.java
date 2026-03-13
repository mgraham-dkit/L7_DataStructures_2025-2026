package utils;

public interface List {
    int getSize();
    String get(int index);
    int indexOf(String target);
    void add(String element);
    void add(int index, String element);
    String remove(int index);
    boolean remove(String target);
    void clear();
}
