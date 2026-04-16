package apps;


import utils.LinkedList;
import utils.List;
import utils.PriorityQueue;

import java.util.Random;
import java.util.Scanner;

public class PriorityQueueTestBed {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM_GENERATOR = new Random();

    private static String generateText(int length){
        if(length < 0){
            throw new IllegalArgumentException("Cannot generate a String with negative length ("+length+ ").");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int characterPos = RANDOM_GENERATOR.nextInt(ALPHABET.length());
            char character = ALPHABET.charAt(characterPos);
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main() {
        List list = new LinkedList();
        PriorityQueue priorityQueue = new PriorityQueue();
        Scanner input = new Scanner(System.in);

        System.out.println("How many Strings would you like to add to the queue?");
        int numStrings = input.nextInt();

        System.out.println("What is the maximum length you wish to have for each String?");
        int maxLength = input.nextInt();

        for (int i = 0; i < numStrings; i++) {
            int randomLength = RANDOM_GENERATOR.nextInt(maxLength+1);

            String randomText = generateText(randomLength);
            priorityQueue.enqueue(randomText);
            list.add(randomText);
        }

        System.out.println("---------List (Originally Entered Order):---------");
        displayList(list);
        System.out.println("--------Queue (Priority Ordering):---------");
        consumeQueue(priorityQueue);
    }

    private static void displayList(List list){
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i + ") " + list.get(i));
        }
    }

    private static void consumeQueue(PriorityQueue queue){
        int i = 0;
        while(!queue.isEmpty()){
            System.out.println(i + ") " + queue.dequeue());
            i++;
        }
    }
}
