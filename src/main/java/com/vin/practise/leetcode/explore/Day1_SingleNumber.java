package com.vin.practise.leetcode.explore;

import java.util.HashSet;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class Day1_SingleNumber {

    public static void main (String[] args) {
        int [] nums = {2,2,1};
        System.out.println("REsult-->"+singleNumber(nums));
    }
    static int singleNumber(int[] nums) {
        int sum =0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (hashSet.contains(nums[i])) {
                sum-=nums[i];
            }
            else {
                sum+=nums[i];
                hashSet.add(nums[i]);
            }
        }
        return sum;
    }
    /**
     * Complexity Analysis
     *
     * Time complexity : O(n \cdot 1) = O(n)O(n⋅1)=O(n). Time complexity of for loop is O(n)O(n). Time complexity of hash table(dictionary in python) operation pop is O(1)O(1).
     *
     * Space complexity : O(n)O(n). The space required by hash\_tablehash_table is equal to the number of elements in \text{nums}nums.
     */
}
