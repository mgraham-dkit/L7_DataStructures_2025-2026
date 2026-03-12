package apps;


import utils.LinkedList;

public class LinkedListTestBed {
    public static void main() {
        LinkedList myList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            myList.add("String " + i);
        }

        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }
}
