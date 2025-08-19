package es6.SyncMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Personalized synchronized Map implementation
* @author Jessica Maio
* */

public class Map {

    private static class Value {
        private int key;
        private String value;

        public Value(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
    private List<Value> table;
    private final int maxSize;

    public Map(int maxSize) {
        this.table = new ArrayList<>();
        this.maxSize = maxSize;
    }

    /** Search and return the value/s associated with that given key, deleting it/them
     *
     * @param key the key associated with the value/s to be searched (if present)
     * @return the value/s associated with the key, or null if not found
     */
    public synchronized String searchAndGet(int key){
        if (table.isEmpty()){
            return null; // No elements in the map
        }
        List<String> value = new ArrayList<>();
        for (int i = table.size()-1; i >= 0 ; i--) { // Iterate from the end to the beginning to simplify removal
            if (key == table.get(i).getKey()){
                value.add(table.get(i).getValue()); // Retrieve the value associated with the key
                table.remove(i); // Remove the entry after retrieving the value
            }
        }
        if (value.isEmpty()) {
            return null; // No value found for the given key
        } else {
            notifyAll();
            return String.join(", ", value); // Return the values as a comma-separated string
        }
    }

    /** Insert a new key-value pair into the map.
     *
     * @param key the key associated with the data to insert
     * @param data the data to insert
     */
    public synchronized void insert(int key, String data) {
        while(table.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                throw new RuntimeException("Thread interrupted while waiting to insert into map");
            }
        }
        table.add(new Value(key, data)); // Add the new key-value pair to the map
    }

}
