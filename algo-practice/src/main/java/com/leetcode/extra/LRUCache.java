package com.leetcode.extra;

import java.util.LinkedHashMap;

/**
 * AN:146
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to get and put.
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    /**
     * Remove the key and push it to the tail of the list, and return its value. If
     * the key does not exist, return -1 instead.
     *
     * @param key
     * @return
     */
    public int get(int key) {
        int value = -1;
        if (cache.containsKey(key)) {
            value = cache.get(key);
            pushToTail(key, value);
        }
        return value;
    }

    /**
     * 1. If we are over capacity, evict the LRU element.
     * 2. If the key we are adding exists, remove it.
     * 3. Add the new key/value to the tail of the list.
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        boolean keyExists = cache.containsKey(key);
        if ((!keyExists) && (cache.size() + 1 > capacity)) {
            evictLRU();
        }
        if (keyExists) {
            pushToTail(key, value);
        } else {
            cache.put(key, value);
        }
    }

    /**
     * Remove element at the head of the list (this will be the LRU element).
     */
    public void evictLRU() {
        int key = cache.keySet().iterator().next();
        cache.remove(key);
    }

    public void pushToTail(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.get(1);
        lruCache.put(1,10);

    }
}
