package CA2_project_material.apps;

import CA2_project_material.utils.HashMap;
import utils.DynamicArray;

import java.util.Scanner;

public class HashMapSampleApplication {
    // Declare a scanner to use across ALL methods
    private static Scanner input;

    public static void addBookToReadingList(HashMap booklistsMap){
        System.out.println("Enter your name:");
        String personName = input.nextLine();

        System.out.println("What do you want to add to your TBR?");
        String bookTitle = input.nextLine();

        // Get the person's TBR
        DynamicArray booklist = booklistsMap.get(personName);

        // If the person doesn't already have a TBR:
        if(booklist == null){
            // create a blank list
            booklist = new DynamicArray();
            // Put this new list into the map
            booklistsMap.put(personName, booklist);
        }

        // Add the new book to their TBR (this IS the list within the map,
        // so updating it here updates the map too)
        booklist.add(bookTitle);
    }

    public static void removeBookFromReadingList(HashMap booklistsMap){
        System.out.println("Enter your name:");
        String personName = input.nextLine();

        System.out.println("What do you want to remove from your TBR?");
        String bookToRemove = input.nextLine();

        // Get the person's TBR list
        DynamicArray booklist = booklistsMap.get(personName);

        // If the person doesn't already have a TBR, tell the user there's no list to remove from
        if(booklist == null){
            System.out.println("You don't have a TBR at the moment!");
        }else {
            // Try to remove the specified book from their TBR
            boolean removed = booklist.remove(bookToRemove);
            // If something was removed, inform the user
            if(removed) {
                System.out.println(bookToRemove + " has been removed from your TBR");
            }else{
                // Otherwise tell the user there was nothing removed
                System.out.println(bookToRemove + " was not found in your TBR");
            }
        }
    }

    public static void searchBookInReadingList(HashMap bookListsMap){
        System.out.println("Enter your name:");
        String personName = input.nextLine();

        // Get the person's TBR list
        DynamicArray booklist = bookListsMap.get(personName);

        // If the person doesn't already have a TBR, tell the user there's no list to search
        if(booklist == null){
            System.out.println("You don't have a TBR at the moment!");
        }else {
            System.out.println("What do you want to search for in your TBR?");
            String bookToFind = input.nextLine();

            int index = booklist.indexOf(bookToFind);
            if(index != -1){
                System.out.println(bookToFind + " IS in your TBR!");
                System.out.println("It's currently in position " + (index+1));
            }else{
                System.out.println("Sorry, " + bookToFind + " isn't in your list. Consider adding it!");
            }
        }
    }

    public static void displayUserReadingList(HashMap bookListsMap){
        System.out.println("Enter your name:");
        String personName = input.nextLine();

        // Get the person's TBR list
        DynamicArray booklist = bookListsMap.get(personName);

        // If the person doesn't already have a TBR, tell the user there's no list to search
        if(booklist == null){
            System.out.println("You don't have a TBR at the moment!");
        }else if(booklist.getSize() == 0){
            // If the TBR is empty, tell the user there're no books in it
            System.out.println("Your TBR is currently empty!");
        }
        else {
            System.out.println("---------- To Be Read ----------");
            for (int i = 0; i < booklist.getSize(); i++) {
                System.out.println((i+1) + ") " + booklist.get(i));
            }
        }
    }

    public static void displayUsersInHashMap(HashMap bookListsMap){
        String [] usernames = bookListsMap.getKeys();

        // If there are no keys (usernames) in the TBRs map
        if(usernames.length == 0){
            // Tell the user
            System.out.println("No users have stored TBRs");
            // Stop running the method - there's nothing left to do
            return;
        }

        System.out.println("---------- User names ----------");
        // Loop through the keys (usernames) retrieved from the map
        for (String username : usernames) {
            System.out.println(username);
        }
    }

    public static void displayTBRsInHashMap(HashMap bookListsMap){
        DynamicArray [] booklists = bookListsMap.getValues();

        // If there are no values (booklists/TBRs) in the TBRs map
        if(booklists.length == 0){
            // Tell the user
            System.out.println("No stored TBRs");
            // Stop running the method - there's nothing left to do
            return;
        }

        System.out.println("---------- TBRs ----------");
        // Loop through the values (booklists/TBRs) retrieved from the map
        for(int i = 0; i < booklists.length; i++) {
            DynamicArray tbrList = booklists[i];
            // Display header
            System.out.println("List " + (i+1) + ":");

            // If the tbr list is empty
            if(tbrList.getSize() == 0){
                // Inform the user
                System.out.println("List is empty");
                // Skip on to the next list
                continue;
            }

            // If the tbr list is NOT empty, display its contents
            for (int j = 0; j < tbrList.getSize(); j++) {
                String title = tbrList.get(j);
                System.out.println("\t" + (j+1) + ") " + title);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public static void displayMenu(){
        System.out.println("-------------------------------------");
        System.out.println("1) Add a book to your TBR");
        System.out.println("2) Remove a book from your TBR");
        System.out.println("3) Search for a book in your TBR");
        System.out.println("4) Display your TBR");
        System.out.println("5) Display the usernames of those with TBRs");
        System.out.println("6) Display all TBRs currently saved");
        System.out.println("exit) Exit the program");
        System.out.println("-------------------------------------");
        System.out.print("Please enter your selection: ");
    }

    public static void executeMenu(HashMap bookListsMap){
        boolean keepRunning = true;

        while(keepRunning){
            // Display the menu of options
            displayMenu();
            String choice = input.nextLine().toLowerCase();
            switch(choice){
                case "1" -> addBookToReadingList(bookListsMap);
                case "2" -> removeBookFromReadingList(bookListsMap);
                case "3" -> searchBookInReadingList(bookListsMap);
                case "4" -> displayUserReadingList(bookListsMap);
                case "5" -> displayUsersInHashMap(bookListsMap);
                case "6" -> displayTBRsInHashMap(bookListsMap);
                case "exit" -> {
                    keepRunning = false;
                    System.out.println("Thank you for using our booklist manager!");
                }
                default -> System.out.println("Invalid option entered.");
            }
        }
    }
    
    public static void main() {
        // Create the program's scanner (to let it interact with the user)
        input = new Scanner(System.in);

        // Set up data to be used in program
        HashMap bookListsMap = new HashMap();
        // Run menu for user interaction
        executeMenu(bookListsMap);

        System.out.println("Farewell...");
        // Close down the program's scanner - this should done once you are finished with the user
        input.close();
    }
}
