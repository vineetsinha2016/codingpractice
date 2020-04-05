package com.vin.practise.leetcode.concepts.recursion;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 */
public class ReverseString {
    public static void main (String[] args ) {
        String input = "hello";
        reverseString(input.toCharArray());
    }
    public static void reverseString(char[] s) {
        int i=0,j=s.length-1;
        helper(s, i, j);
    }
    static void helper (char[] s, int i, int j) {
        //base case
        if (i>=j) {
            System.out.println("Result is :"+ Arrays.toString(s));
            return;
        }
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
        helper(s, i+1, j-1);
    }
}
