package com.vin.practise.leetcode.general.design;

import java.util.LinkedList;

/***
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * Example:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 *
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 *
 *
 */
public class DesignAHashSet {
    private Bucket[] bucketArray;
    private Integer keyRange;
    /** Initialize your data structure here. */
    public DesignAHashSet() {
        keyRange = 769;
        bucketArray = new Bucket[769];
        for (int i=0;i<keyRange;i++) {
            bucketArray[i] = new Bucket();
        }
    }
    protected int _hash (int key) {
        return key % this.keyRange;
    }

    public void add(int key) {
        int index =  this._hash(key);
        bucketArray[index].insert(key);
    }

    public void remove(int key) {
        int index = this._hash(key);
        bucketArray[index].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = this._hash(key);
        return bucketArray[index].keyExists(key);
    }
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    class Bucket {
        private LinkedList<Integer> linkedList;
        public Bucket() {
            linkedList = new LinkedList<>();
        }
        public void insert(Integer key) {
            if (linkedList.indexOf(key)==-1) {
                linkedList.addFirst(key);
            }
            else linkedList.add(key);
        }
        public void delete (Integer key) {
            linkedList.remove(key);
        }
        public boolean keyExists(Integer key) {
            return linkedList.indexOf(key)!=-1;
        }
    }
}
