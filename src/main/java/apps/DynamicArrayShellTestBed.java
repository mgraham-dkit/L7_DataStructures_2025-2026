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

    private static void displayList(DynamicArray_Shell myList) {
        System.out.println("List contents: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }
}
