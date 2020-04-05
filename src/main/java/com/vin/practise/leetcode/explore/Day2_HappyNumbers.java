package com.vin.practise.leetcode.explore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/***
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Day2_HappyNumbers {
    public static void main (String [] args) {
        int n=7;//90;//19;
        System.out.println("Result-->"+isHappy(n));
    }
    static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while(n!=1) {
            if (hashSet.contains(n)) break;//termination condition
            hashSet.add(n);
            List<Integer> allNums = getAllNums(n);
            System.out.println("Nums -->"+allNums);
            int sum =0;
            for (int num : allNums) {
                sum+=num*num;
            }
            n=sum;
        }
        return n==1;
    }

    private static List<Integer> getAllNums(int n) {
        List<Integer> allNums = new ArrayList<>();
        int temp;
        while (n!=0) {
            temp =n%10;
            allNums.add(temp);
            n=n/10;
        }
        return allNums;
    }
}
