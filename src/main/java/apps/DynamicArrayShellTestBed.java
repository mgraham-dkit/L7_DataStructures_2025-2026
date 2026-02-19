package apps;

import shells.DynamicArray_Shell;

import java.util.Scanner;

public class DynamicArrayShellTestBed {
    public static void main() {
        DynamicArray_Shell myList = new DynamicArray_Shell();

        // Uncomment the actions as you finish the methods
//        System.out.println("List size: " + myList.size());
//        displayList(myList); // Uses size() and get()
//        checkList(myList); // Uses contains()
//        searchList(myList); // Uses indexOf()
//        addToList(myList); // Uses add() to add to end
//        addToListAtPosition(myList); // Uses add(element, index) to add at specified index
//        removeFromListAtPosition(myList); // Uses remove(index) to remove from a specific position
//        removeElementFromList(myList); // Uses remove(element) to remove first instance of a specific element
    }

    private static void checkList(DynamicArray_Shell myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text to be found: ");
        String target = input.nextLine();
        boolean found = myList.contains(target);
        if(found){
            System.out.println(target + " found!");
        }else{
            System.out.println("Sorry, " + target + " was not found in the list.");
        }
    }

    private static void searchList(DynamicArray_Shell myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text to be found: ");
        String target = input.nextLine();
        int index = myList.indexOf(target);
        if(index != -1){
            System.out.println(target + " found at " + index + ".");
        }else{
            System.out.println("Sorry, " + target + " was not found in the list.");
        }
    }

    private static void addToList(DynamicArray_Shell myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text to be added: ");
        String newElement = input.nextLine();
        myList.add(newElement);
    }

    private static void addToListAtPosition(DynamicArray_Shell myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text to be added: ");
        String newElement = input.nextLine();
        int index = DynamicArrayShellTestBed.getInt("Enter the index to add at: ");
        myList.add(index, newElement);
    }

    private static void removeFromListAtPosition(DynamicArray_Shell myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the index to delete from: ");
        int index = DynamicArrayShellTestBed.getInt("Enter the index to remove from: ");
        String deleted = myList.remove(index);
        System.out.println("Deleted \"" + deleted + "\" from list");
    }

    private static void removeElementFromList(DynamicArray_Shell myList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the element to delete: ");
        String element = input.nextLine();
        boolean deleted = myList.remove(element);
        if(deleted){
            System.out.println("\"" + element + "\" was successfully deleted from the list.");
        }else{
            System.out.println("No instance was found.");
        }
    }

    private static void displayList(DynamicArray_Shell myList) {
        System.out.println("List contents: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }

    private static int getInt(String prompt){
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int value = 0;
        while(!valid) {
            System.out.println(prompt);
            if (input.hasNextInt()) {
                value = input.nextInt();
                valid = true;
            } else {
                System.out.println("Please enter a number!");
                input.nextLine();
            }
        }
        return value;
    }
}
