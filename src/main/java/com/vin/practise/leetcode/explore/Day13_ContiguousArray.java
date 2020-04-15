package com.vin.practise.leetcode.explore;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Day13_ContiguousArray {
    public static void main (String[] args) {
        int [] nums = {0,0,0,0,0,0,1,1,1,1,1,0,1};//{0,1,0};//{0,0,1,0,1,1,1,0,1};
        System.out.println("Reault-->"+findMaxLength(nums));
    }
    static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;

    }
    /**
     * Algorithm
     *
     * This approach relies on the same premise as the previous approach. But, we need not use an array of size \text{2n+1},
     * since it isn't necessary that we'll encounter all the count values possible. Thus, we make use of a
     * HashMap  to store the entries in the form of (index, count). We make an entry for a
     * count in the mapmap whenever the countcount is encountered first, and later on use the
     * correspoding index to find the length of the largest subarray with equal no. of zeros and ones when the same
     * count is encountered again.
     *
     * The following animation depicts the process:
     * https://leetcode.com/problems/contiguous-array/solution/
     *
     */
}
