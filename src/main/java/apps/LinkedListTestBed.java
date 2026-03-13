package apps;


import utils.LinkedList;

public class LinkedListTestBed {
    public static void main() {
        LinkedList myList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            myList.add("String " + i);
        }

        displayList(myList);

        long start = System.nanoTime();
        int index = myList.lastIndexOf("String 9");
        long end = System.nanoTime();
        long timeTaken = end - start;

        System.out.println("String 9 was found at position " + index);
        System.out.println("Time taken to find element: " + timeTaken);

        // Test remove logic - remove from start
        int removeIndex = 0;
        String removed = myList.remove(removeIndex);
        System.out.println("Removed from " + removeIndex + ": " + removed);
        displayList(myList);

        // Remove from end
        removeIndex = myList.getSize()-1;
        removed = myList.remove(removeIndex);
        System.out.println("Removed from " + removeIndex + ": " + removed);
        displayList(myList);

        // Confirm last was updated correctly
        System.out.println("Adding new last element (String 10)");
        myList.add("String 10");
        displayList(myList);

        // Remove from middle
        removeIndex = myList.getSize()/2;
        removed = myList.remove(removeIndex);
        System.out.println("Removed from " + removeIndex + ": " + removed);
        displayList(myList);
    }

    private static void displayList(LinkedList myList) {
        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }
}
