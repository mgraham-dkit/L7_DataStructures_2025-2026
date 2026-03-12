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
        long start = System.nanoTime();
        int index = myList.lastIndexOf("String 9");
        long end = System.nanoTime();
        long timeTaken = end - start;

        System.out.println("String 9 was found at position " + index);
        System.out.println("Time taken to find element: " + timeTaken);
    }
}
