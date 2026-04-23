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
}
