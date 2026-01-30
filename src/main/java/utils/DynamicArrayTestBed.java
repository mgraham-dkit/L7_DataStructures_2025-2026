package utils;


public class DynamicArrayTestBed {
    public static void main() {
        DynamicArray myList = new DynamicArray();
        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }
}
