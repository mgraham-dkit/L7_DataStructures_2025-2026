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

        boolean dataRemoved = myList.remove("String 5");
        if(dataRemoved){
            System.out.println("String 5 was removed from the list");
        }else{
            System.out.println("Could not remove String 5 from list");
        }
        System.out.println("Updated list:");
        for (int i = 0; i < myList.getSize(); i++) {
            System.out.println(i + ") " + myList.get(i));
        }
    }
}
