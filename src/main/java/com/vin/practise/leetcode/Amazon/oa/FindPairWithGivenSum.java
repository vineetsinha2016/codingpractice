package com.vin.practise.leetcode.Amazon.oa;

import java.util.*;

/**
 * Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.
 *
 * Conditions:
 *
 * You will pick exactly 2 numbers.
 * You cannot pick the same element twice.
 * If you have muliple pairs, select the pair with the largest number.
 *
 * Example 1:
 *
 * Input: nums = [1, 10, 25, 35, 60], target = 90
 * Output: [2, 3]
 * Explanation:
 * nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
 * Example 2:
 *
 * Input: nums = [20, 50, 40, 25, 30, 10], target = 90
 * Output: [1, 5]
 * Explanation:
 * nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
 * nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
 * You should return the pair with the largest number.
 */
public class FindPairWithGivenSum {
    public static void main (String[] args) {
        int[] nums ={50, 20, 10, 25, 30, 40};//{20,50,40,25,30,10};//{1, 10, 25, 35, 60};//
        int target = 90;
        System.out.println("Result-->"+ Arrays.toString(findIndexes(nums, target)));
    }
    static int[] findIndexes(int[] nums, int target) {
        //element  as key and index as value
        int newTarget = target-30;
        Map<Integer,Integer> sumMap = new HashMap<>();
        int[] result = new int[] {-1,-1};int max =0;
        for (int i=0;i<nums.length;i++) {
            if (sumMap.containsKey(newTarget-nums[i])) {
                if(newTarget-nums[i] > max || nums[sumMap.get(newTarget-nums[i])] > max) {
                    result=(new int[]{sumMap.get(newTarget-nums[i]),i});
                    max = Math.max(newTarget-nums[i], nums[sumMap.get(newTarget-nums[i])]);
                }
            }
            sumMap.put(nums[i],i);
        }
        return result;
        /*Arrays.sort(nums); int newTarget = target-30;
        int i=0,j=nums.length-1;
        List<int[]> listOfIndices = new ArrayList<>();
        while(i<j) {
            if (nums[i]+nums[j]==newTarget) {
                if (listOfIndices.size()==0)
                        listOfIndices.add(new int[]{i,j});
                else {
                    int max=0;
                    for (int[] r : listOfIndices) {
                        if (r[0]>max) max=r[0];
                        if (r[1]>max) max=r[1];
                        if (nums[i]>max) max=nums[i];
                        if (nums[j]>max) max=nums[j];
                    }
                    if (max==nums[i] || max==nums[j]) {
                        listOfIndices.remove(0);
                        listOfIndices.add(new int[]{i,j});
                    }
                    else {
                        System.out.println("no action required");
                    }
                }
                i++;j--;
            }
            else if (nums[i]+nums[j]>newTarget) {
                j--;
            }
            else i++;
        }
        return listOfIndices.size()>0 ? listOfIndices.get(0) :new int[] {0,0};*/
    }

}
