package com.vin.practise.leetcode.explore;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Day4_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};//{0,1,0,3,12};
        System.out.println("Result-->"+ Arrays.toString(moveZeroes(nums)));
    }
    static int[] moveZeroes(int[] nums) {
        int nonZeroesCount=0;
        //Move all non-zeroes to start of array
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=0)
            nums[nonZeroesCount++] = nums[i];
        }
        //Now mark all the moved ones /last ones to 0
        for (int i=nonZeroesCount;i<nums.length;i++) {
            nums[i]=0;
        }
        return nums;
    }
}
