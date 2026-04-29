package CA2_project_material.utils;

// You will need to provide your own implementation of DynamicArray
// This can also be switched to LinkedList if you would prefer!
import utils.DynamicArray;

// This built-in class uses the built-in ArrayList class. This is the only place where that's acceptable,
// and it never leaves this class - it's used by the map as a container for the entries
import java.util.ArrayList;

public class HashMap {
    private ArrayList<Entry> [] map = new ArrayList[128];
    private int count = 0;

    private static class Entry {
        // Set the key as final as the key can never change
        private final String key;
        private DynamicArray value;

        public Entry(String key, DynamicArray value){
            this.key = key;
            this.value = value;
        }
    }

    private static void validateKeyForNull(String key) {
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public int count(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    private int hashFunction(String key){
        // Turn key into a number
        int hash = key.hashCode();

        // Turn number into POSITIVE version of number (> 0)
        hash = Math.abs(hash);

        // Make number fit within range of possible map slots
        hash = hash % map.length;

        return hash;
    }

    public DynamicArray get(String key){
        // Check key is not null
        validateKeyForNull(key);

        // Neutralise the case of the key - reset it to all lowercase
        key = key.toLowerCase();

        // Calculate where this key should be within the map (if it's present)
        int hash = hashFunction(key);
        // Get the list of all entries stored in this position
        ArrayList<Entry> slotEntries = map[hash];
        // If there are no entries in this position, the supplied key is not in the map
        if(slotEntries == null){
            // Return null as the key is not present
            return null;
        }

        // Loop through each entry in the calculated slot
        for (Entry slotEntry : slotEntries) {
            // If the current entry's key matches the one we're searching for
            if(slotEntry.key.equalsIgnoreCase(key)){
                // Return the value (the list of filenames) for this key
                return slotEntry.value;
            }
        }
        // Return null because even though the slot had key-value pairs in it,
        // none of them match the key we have
        return null;
    }

    public DynamicArray put(String key, DynamicArray value){
        // Check key is not null
        validateKeyForNull(key);

        // Neutralise the case of the key - reset it to all lowercase
        key = key.toLowerCase();

        // Calculate where this key should be stored within the map
        int hash = hashFunction(key);

        // If the slot is empty, create a list and save it in there
        // (so we have somewhere to put the new entry)
        if(map[hash] == null){
            map[hash] = new ArrayList<Entry>();
        }

        // Get the list of all entries already stored in this position (it may be empty)
        ArrayList<Entry> slotEntries = map[hash];
        // Loop through each entry in the calculated slot
        for (Entry slotEntry : slotEntries) {
            // If the current entry's key matches the one we're searching for
            if(slotEntry.key.equals(key)){
                // Save the existing value for this key
                DynamicArray oldValue = slotEntry.value;

                // Set the value to be the value supplied as a parameter
                slotEntry.value = value;

                // Return the old value (the list of filenames) that was replaced for this key
                return oldValue;
                // We don't increase the count here as we're REPLACING AN EXISTING ONE,
                // not adding a new Entry
            }
        }

        // The key does not already exist in the slot, so we need to:
        // 1) Wrap the supplied key and value in an Entry
        Entry newEntry = new Entry(key, value);

        // 2) Add that Entry to the slot's list
        slotEntries.add(newEntry);

        // 3) Increase the number of key-value pairs in the map
        count++;

        // 4) Return null because nothing was replaced
        return null;
    }

    public DynamicArray remove(String key){
        // Check key is not null
        validateKeyForNull(key);

        // Neutralise the case of the key - reset it to all lowercase
        key = key.toLowerCase();

        // Calculate where this key should be within the map (if it's present)
        int hash = hashFunction(key);
        // Get the list of all entries stored in this position
        ArrayList<Entry> slotEntries = map[hash];
        // If there are no entries in this position, the supplied key is not in the map
        if(slotEntries == null){
            // Return null as the key is not present
            return null;
        }

        // Loop through each entry in the calculated slot
        for (int i = 0; i < slotEntries.size(); i++) {
            Entry slotEntry = slotEntries.get(i);
            // If the current entry's key matches the one we're attempting to remove
            if(slotEntry.key.equalsIgnoreCase(key)){
                // Store the value (the list of filenames) for this key
                DynamicArray removed = slotEntry.value;

                // Remove the current entry from the slot's list
                slotEntries.remove(i);
                // Decrease how many key-value pairs are in the map
                count--;
                // Return the deleted value associated with this key
                return removed;
            }
        }

        // Return null because even though the slot had key-value pairs in it,
        // none of them match the key we have
        return null;
    }

    public String[] getKeys(){
        // Create an array of Strings to hold the keys stored in the map
        // Use the count of key-value pairings to know how big to make the array
        String [] keys = new String[count];
        // Create a variable to track how many keys we have saved so far
        int savedKeyCount = 0;
        for (int i = 0; i < map.length; i++) {
            // Get the list of entries for the current slot
            ArrayList<Entry> slotEntries = map[i];
            // If it's blank, skip to next slot
            if(slotEntries == null){
                continue;
            }

            // For each entry in the slot
            for (int j = 0; j < slotEntries.size(); j++) {
                // Get the current entry
                Entry currentEntry = slotEntries.get(j);
                // Add the current entry's key to the array of keys
                // Use the count of saved keys to decide where to add this key
                keys[savedKeyCount] = currentEntry.key;
                // Increase the number of keys we have saved by 1
                savedKeyCount++;
            }
        }
        // Once we have looped through the whole map, return the completed array of keys
        return keys;
    }

    public DynamicArray[] getValues(){
        // Create an array of DynamicArrays to hold the values stored in the map
        // Use the count of key-value pairings to know how big to make the array
        DynamicArray [] values = new DynamicArray[count];
        // Create a variable to track how many values we have saved so far
        int savedValueCount = 0;
        for (int i = 0; i < map.length; i++) {
            // Get the list of entries for the current slot
            ArrayList<Entry> slotEntries = map[i];
            // If it's blank, skip to next slot
            if(slotEntries == null){
                continue;
            }

            // For each entry in the slot
            for (int j = 0; j < slotEntries.size(); j++) {
                // Get the current entry
                Entry currentEntry = slotEntries.get(j);
                // Add the current entry's value to the array of values
                // Use the count of saved values to decide where to add this value
                values[savedValueCount] = currentEntry.value;
                // Increase the number of values we have saved by 1
                savedValueCount++;
            }
        }
        // Once we have looped through the whole map, return the completed array of values
        return values;
    }
}
