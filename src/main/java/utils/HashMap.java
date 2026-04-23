package utils;

public class HashMap {
    private static final int INITIAL_SIZE = 128;
    private Entry[] map;
    private int count;

    public HashMap() {
        this.map = new Entry[INITIAL_SIZE];
        this.count = 0;
    }

    private static class Entry{
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int count(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    int hashFunction(String key){
        // Turn key into number
        int hash = key.hashCode();

        // Turn number into POSTIVE version of number (> 0)
        hash = Math.abs(hash);

        // Make number fit within range of map slots
        hash = hash % map.length;

        return hash;
    }

    public void put(String key, String value){
        // VALIDATE
        validateKeyForNull(key);

        // Calculate where this key belongs within the map
        int hash = hashFunction(key);
        // Wrap key and value together so we can store them in a single position
        Entry newEntry = new Entry(key, value);
        // Store key-value pair in the map at the calculated position
        map[hash] = newEntry;
    }

    private static void validateKeyForNull(String key) {
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public String get(String key){
        // VALIDATE key - make sure it's not null
        validateKeyForNull(key);

        // Calculate where this key belongs within the map
        int hash = hashFunction(key);


        Entry match = map[hash];
        if(match == null){
            return null;
        }
        return match.value;
    }
}