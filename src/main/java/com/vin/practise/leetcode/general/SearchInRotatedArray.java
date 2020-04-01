package com.vin.practise.leetcode.general;

/***
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
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
public class SearchInRotatedArray {
    public static void main (String[] args) {
        int [] nums = {4,5,6,7,0,1,2};int key =3;
        System.out.println("Result --> "+searchInArray(nums, key));
    }
    static int searchInArray(int[] nums, int key) {
        if (nums==null || nums.length==0) return -1;
        int i=0, n=nums.length-1;
        while (i<=n) {
            int mid=i + (n-i)/2;
            if (nums[mid]==key) return mid;
            if (nums[mid]>=nums[i]) {//first sub array is intact
                if (key>=nums[i] && key<nums[mid]) n=mid-1;//if number is between start and middle then search in first
                else i = mid +1; //search in other sub array since key is not here
            }
            else {//first subarray is not intact so check in another subarray
                if (key<=nums[n] && key>nums[mid]) i=mid+1;
                else n=mid-1;
            }
        }
        return -1;
    }


}
