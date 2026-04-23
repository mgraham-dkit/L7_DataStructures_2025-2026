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


}
