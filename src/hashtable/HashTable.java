package hashtable;

public class HashTable {
    private int numOfBuckets;
    private int size;

    private HashNode[] buckets;

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        buckets = new HashNode[capacity];
        this.size = 0;
    }

    private class HashNode {
        private int key;
        private String value;
        private HashNode next;

        public HashNode(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
