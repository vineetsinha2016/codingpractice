package com.vin.practise.leetcode.explore;

import java.util.HashMap;

/***
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Day3_MaximumSubArray {
    public static void main (String[] args) {
        int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Result-->"+maxSubArray(nums));
    }
    static  int maxSubArray(int[] nums) {
        //Greedy approach : Keep a local sum and global sum
        //Step 1: initialize both with first element and loop through remaining elements
        //Step 2: keep adding next element to current sum and then assign max value of current sum or new number to itself
        //Step 3 : keep assigning max value of current sum to global sum
        /*int result =nums[0]; int currentSum = nums[0];
        for (int i=1;i<nums.length;i++) {
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            result = Math.max(result, currentSum);
        }
        return result;*/
        /*
        Complexity Analysis
                Time complexity : O(N) since it's one pass along the array.

                Space complexity : O(1), since it's a constant space solution.
         */

        /**
         * Dynamic Programming (Kadane's algorithm) approach
         * Intuition
         *
         * The problem to find sum or maximum or minimum in an entire array or in a fixed-size sliding window could be solved by the dynamic programming (DP) approach in linear time.
         *
         * There are two standard DP approaches suitable for arrays:
         *
         * Constant space one. Move along the array and modify the array itself.
         *
         * Linear space one. First move in the direction left->right, then in the direction right->left. Combine the results. Here is an example.
         *
         * Let's use here the first approach since one could modify the array to track the current local maximum sum at this given point.
         *
         * Next step is to update the global maximum sum, knowing the local one.
         */
        int result =nums[0];
        for (int i=1;i<nums.length;i++) {
            //if last number was positive
            if (nums[i-1] > 0) nums[i] = nums[i-1]+nums[i];
            result = Math.max(result, nums[i]);
        }
        return result;
        /***
         * Complexity Analysis
         *
         * Time complexity : O(N) since it's one pass along the array.
         *
         * Space complexity : O(1), since it's a constant space solution.
         */
    }


}
