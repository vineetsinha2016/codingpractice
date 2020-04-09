package com.vin.practise.leetcode.explore;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * Example 3:
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 */
public class Day7_CountingElements {
    public static void main (String[] args) {
        int[] nums = {1,1,3,3,5,5,7,7};//{1,2,3};//{1,1,2};//{1,3,2,3,5,0};//{1,2,3};{1,1,2,2};////
        System.out.println("Result --> "+countElements(nums));
    }

    /**
     * Idea is to put the elements in hashmap and get the count
     * then iterate through keys and get the occurences and increment the
     * found x+1 entries accordingly.
     * @param arr
     * @return
     */
    static int countElements(int[] arr) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],1);
            }
            else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.containsKey(key+1)) {
                result+=map.get(key);
                //TODO: Learnt following loop wasn't required
                /*if (map.get(key)<=map.get(key+1)) result+=map.get(key);
                else result+=map.get(key+1);*/
            }
        }
        return result;
    }
}
