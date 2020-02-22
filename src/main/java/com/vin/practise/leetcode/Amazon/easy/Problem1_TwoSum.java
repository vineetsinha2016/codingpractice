package com.vin.practise.leetcode.Amazon.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Problem1_TwoSum {
    public  static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myHashMap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (myHashMap.containsKey(target-nums[i])) {
                return new int[] {myHashMap.get(target-nums[i]), i};
            }
            else {
                myHashMap.put(nums[i],i);
            }
        }
        return new int[] {0,0};

        //naive/wrong solution starts  :: Time complexity : O(n^2)  Space complexity : O(1).
        /*int temp = 0;
        for (int i=0;i<nums.length;i++) {
            temp = target - nums[i];
            System.out.println("value of temp :"+temp);
            if (search(nums, temp,i)!=-1) {
                return new int[] {i, search(nums,temp,i)};
            }
        }
        System.out.println("Returning NOTHING");
        return new int[] {0,0};*/
        //naive solution ends
    }

    public static int search(int[] nums, int num, int j) {
        for (int i=j+1;i<nums.length;i++) {
            System.out.println("returning index from search::"+i);
            if (nums[i]==num) return i;
        }
        return -1;
    }

    public static void main (String [] args) {
        int [] nums = {1,3,2,4};//{11, 2, 7, 15};//{2, 7, 11, 15};
        int target = 7;
        System.out.println("result -->"+ Arrays.toString(twoSum(nums, target)));
    }
    /**
     * Lessons learnt here :
     * Whenever you see the searching array twice problem go for hashmap
     * Trick is to choose write key.
     * 1. Hashmap can search contains both by keys and values
     * 2. You can only get the answers by hashmap.get() method that is by keys. You can't get by value
     * so choose the key of hashmap wisely.
     *
     * What is the best way to maintain a mapping of each element in the array to its index? A hash table.
     * We reduce the look up time from O(n)O(n) to O(1)O(1) by trading space for speed.
     * A hash table is built exactly for this purpose, it supports fast look up in near constant time.
     * I say "near" because if a collision occurred, a look up could degenerate to O(n)O(n) time.
     * But look up in hash table should be amortized O(1)O(1) time as long as the hash function was chosen carefully.
     *
     * Complexity Analysis:
     *
     * Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
     *
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
     */
}
