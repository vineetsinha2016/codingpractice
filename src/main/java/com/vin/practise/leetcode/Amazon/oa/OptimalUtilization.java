package com.vin.practise.leetcode.Amazon.oa;

import java.util.*;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and
 * the second integer represents a value. Your task is to find an element from a and an element form b such that
 * the sum of their values is less or equal to target and as close to target as possible. Return a list
 * of ids of selected elements. If no pair is possible, return an empty list.
 *
 * Example 1:
 *
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 *
 * Output: [[2, 1]]
 *
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 *
 * Example 2:
 *
 * Input:
 * a = [[1, 3], [2, 5], [3, 7], [4, 10]]
 * b = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * target = 10
 *
 * Output: [[2, 4], [3, 2]]
 *
 * Explanation:
 * There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
 * Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
 * These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 *
 * Example 3:
 *
 * Input:
 * a = [[1, 8], [2, 7], [3, 14]]
 * b = [[1, 5], [2, 10], [3, 14]]
 * target = 20
 *
 * Output: [[3, 1]]
 * Example 4:
 *
 * Input:
 * a = [[1, 8], [2, 15], [3, 9]]
 * b = [[1, 8], [2, 11], [3, 12]]
 * target = 20
 *
 * Output: [[1, 3], [3, 2]]
 *
 */
public class OptimalUtilization {
    public static void main (String[] args) {
        /*List<int[]> a = new ArrayList<>();List<int[]> b = new ArrayList<>();
        a.add(new int[] {1,8});a.add(new int[] {2, 15});a.add(new int[] {3, 9});
        //int[][] a = {{1, 8}, {2, 15}, {3, 9}};
        //int[][] b = {{1, 8}, {2, 11}, {2, 11}};
        b.add(new int[] {1, 8});b.add(new int[] {2, 11});b.add(new int[] {2, 11});
        int target = 20;
        a.forEach(x-> {
            for (int z : x) {
                System.out.println("A-->"+z);
            }
        });*/
        List<List<Integer>> listA = new ArrayList<>();
        listA.add(Arrays.asList(1,8));
        listA.add(Arrays.asList(2,7));
        listA.add(Arrays.asList(3,14));
        List<List<Integer>> listB = new ArrayList<>();
        listB.add(Arrays.asList(1,5));
        listB.add(Arrays.asList(2,10));
        listB.add(Arrays.asList(3,14));
        int target =20;
        System.out.println("listA-->"+listA);
        System.out.println("listB-->"+listB);
        System.out.println("Result -->"+closestSum(listA, listB, target));
    }

    /*static List<int[]> solution(List<int[]> a, List<int[]> b, int target){

    }*/
    //Brute Force : O(m*n)
    /*public static List<List<Integer>> closestSum(List<List<Integer>> listA, List<List<Integer>> listB, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        for (List<Integer> lista : listA) {
            int first = lista.get(1);
            for (List<Integer> listb : listB) {
                //System.out.println(result);
                int second = listb.get(1);
                if ((first+second) <=target ) {
                    if (target - (first+second) <  diff) {
                        result.clear();
                        result.add(new ArrayList<>(Arrays.asList(lista.get(0), listb.get(0))));
                        diff = target - (first+second);
                    } else if (target - (first+second) ==  diff) {
                        result.add(new ArrayList<>(Arrays.asList(lista.get(0), listb.get(0))));
                    }
                }
            }
        }
        System.out.println("Output: " + result);
        return result;
    }*/
    //In my thought, we can sort forwardRouteList and returnRouteList by its second element as first.
    // What we really care is the sum of route dist must be smaller than maxTravelDist and as large as possible.
    // We can set two pointers and traverse two sorted arrays to find the max value (and the combination of course).
    // Since the sorting part complexity is O(MlogM + NlogN) and two-pointer traversal is O(M + N),
    // the final complexity can be regarded as O(KlogK) where K is the longest input array.
    public static List<List<Integer>>  closestSum(List<List<Integer>> listA, List<List<Integer>> listB, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len1 = listA.size(), len2 = listB.size();
        if(len1 == 0 || len2 == 0) return res;
        Collections.sort(listA, (a, b) -> (a.get(1) - b.get(1)));//Sort the list based on second element's value
        System.out.println("List A after Sorting--->"+listA);
        Collections.sort(listB, (a, b) -> (a.get(1) - b.get(1)));//Sort the list based on second element's value
        System.out.println("List B after Sorting -->"+listB);
        int left = 0, right = len2 - 1, maxVal = -1;//left pointer 0 this will go till listA.size()-1(len1), right pointer listb.size() -1, max value =-1
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        while(left < len1 && right >= 0){
            int sum = listA.get(left).get(1) + listB.get(right).get(1);
            if(sum > target){ --right; continue;}
            if(sum >= maxVal){
                int r = right;
                map.putIfAbsent(sum, new ArrayList<>());
                // check the duplicates
                while(r >= 0 && listB.get(r).get(1) == listB.get(right).get(1)){
                    List<Integer> list = new ArrayList<>();
                    list.add(listA.get(left).get(0)); list.add(listB.get(r).get(0));
                    map.get(sum).add(list); --r;
                }
                maxVal = sum;
            }
            ++left;
        }
        return map.get(maxVal);
    }
}
