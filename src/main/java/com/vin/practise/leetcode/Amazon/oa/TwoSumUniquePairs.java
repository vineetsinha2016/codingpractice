package com.vin.practise.leetcode.Amazon.oa;

import java.util.HashMap;
import java.util.HashSet;

/***
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.
 *
 * Example 1:
 *
 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
 * Output: 2
 * Explanation:
 * 1 + 46 = 47
 * 2 + 45 = 47
 * Example 2:
 *
 * Input: nums = [1, 1], target = 2
 * Output: 1
 * Explanation:
 * 1 + 1 = 2
 * Example 3:
 *
 * Input: nums = [1, 5, 1, 5], target = 6
 * Output: 1
 * Explanation:
 * [1, 5] and [5, 1] are considered the same.
 */
public class TwoSumUniquePairs {
    public static void main (String[] args) {
        int[] nums = {1, 1, 2, 45, 46, 46};//{1,-1};//{1,1};//{1, 5, 1, 5};////
        int target =47;//0;//2;//6;//
        System.out.println("Result-->"+findUniquePairs(nums, target));
    }
    static int findUniquePairs (int[] nums, int target) {
        //Step 1: put elements in hashmap with value as key and index as value if not available
        //Step 2: loop through and check if target-current value exists in hashmap. if yes, increment count.
        //Step 3: avoid counting duplicates how? use hashSet may be
        //edge case is 1,1 in array and target =2
        //O(n)
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> track = new HashSet<>();
        int result =0;
        for (int i=0;i<nums.length;i++) {
            if (set.contains(target-nums[i]) && !track.contains(nums[i])) {
                result++;
                track.add(nums[i]);track.add(target-nums[i]);
            }
            else {//if (!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        return result;
        //My failed solution
        /*HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(target-nums[i]) && (!hashSet.contains(target-nums[i]) || !hashSet.contains(nums[i]))) {
                hashSet.add(nums[i]);hashSet.add(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        if (hashSet.size()>0) return hashSet.size()/2;
        return 0;*/
    }
}
