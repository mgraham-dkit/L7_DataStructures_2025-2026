package apps;


import utils.DynamicArray;

public class DynamicArrayTestBed {
    public static void main() {
        DynamicArray myList = new DynamicArray();

        for (int i = 0; i < 10; i++) {
            myList.add("String " + i);
        }

        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }

        String removed = myList.remove(8);
        System.out.println(removed + " removed from position 8");

        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }
}
