// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity

class LRUCache {
    private final int capacity;
    private final HashMap<Integer,Integer> cache;
    private final LinkedHashSet<Integer> usage;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.usage= new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        usage.remove(key);
        usage.add(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            usage.remove(key);
        }
        else if(cache.size()>=capacity){
           int lrukey = usage.iterator().next();
           usage.remove(lrukey);
           cache.remove(lrukey);
        }
        cache.put(key,value);
        usage.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
