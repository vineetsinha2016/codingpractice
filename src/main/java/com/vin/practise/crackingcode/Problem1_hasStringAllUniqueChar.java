package com.vin.practise.crackingcode;

/**
 * Write an alogrithm to find if all the characters in a string are unique
 *
 * Idea is to compare each character of first half of word with all the characters in second half.
 * check blank or null conditions
 * run the first loop from start till middle of the length of the word (i)
 * run another loop from last position till middle of the word inside first loop (j)
 * keep comparing characters at i and j and return false as soon as any character matches
 *
 */
public class Problem1_hasStringAllUniqueChar {
    public static void main(String[] args) {
        String s = "abcdefghakl";//"aa";
        System.out.println("Result -->"+hasAllUnique(s));
    }
    static boolean hasAllUnique(String s) {
        for (int i=0;i<s.length()/2;i++) {//Kind of binary search
            int j=s.length()-1;
            while (j>=s.length()/2) {
                if (s.charAt(i)==s.charAt(j)) {
                    return false;
                }
                j--;
            }
        }
        return true;
    }
}
