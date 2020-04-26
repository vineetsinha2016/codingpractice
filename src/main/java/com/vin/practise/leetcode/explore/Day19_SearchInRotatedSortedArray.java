package com.vin.practise.leetcode.explore;

/***
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Day19_SearchInRotatedSortedArray {
    public static void main (String[] args) {
        int[] nums = {5,1,2,3,4};

                //{4,5,6,7,0,1,2}; //0
        //{4,-2,-1,0,1,2};
        //{4,5,6,7,0,1,2};
        int target = 1;//0;
                //6;//0;
        System.out.println("Result --->"+search(nums, target));
    }
    static int search(int[] nums, int target) {
        if (nums==null) return -1;
        int index = -1;int start = 0, end =nums.length-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (target == nums[mid]) return mid;
            if (nums[start] <= nums[mid]) { //the first array is intact
                //a.
                if (target>=nums[start] && target<nums[mid]) end = mid-1;
                else start = mid +1;//search in another sub array
            }
            else {//first sub array was not intact
                if (target <= nums[end] && target > nums[mid]) start = mid+1;
                else end = mid-1;
            }
        }
        return index;
    }
}
