package com.vin.practise.leetcode.Amazon.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringNoRepeat {
    public static void main (String[] args) {
        String s="abcabcbb";//"pwwkew";//"bbbbb";//
        System.out.println("Result--->"+lengthOfLongestSubstring(s));
    }
    static int lengthOfLongestSubstring(String s) {
        int res =0;
        //expectation will be O(n)
        //Idea is if we have looked in the string s(i,j-1) & no repeat has been found, then we
        //just have to check if s(j) is already there.
        //First use Hash set, Keep two counters i and j both start with 0. Loop on both less than n (length of str)
        //IF element present in set, remove the element at i and increment i. Calculate ans = MAx of ans, j-1
        //if not present, add it in set
        /*int ans = 0,i=0,j=0 ;
        HashSet<Character> set = new HashSet<>();
        while (i<s.length() && j<s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            else {
                set.add(s.charAt(j++));
                ans=Math.max(ans, j-i);
            }
        }
        System.out.println("set-->"+set);
        return ans;*/
/**
 * Instead of using a set to tell if a character exists or not, we could define a mapping of the
 * characters to its index. Then we can skip the characters immediately when we found a repeated character.
 *
 * The reason is that if s[j] have a duplicate in the range [i,j) with index j'
 * ′
 *  , we don't need to increase i little by little. We can skip all the elements in the range [i, j']
 * ′
 *  ] and let i to be j' + 1
 * ′
 *  directly.
 */
        //TO further optimize take map
        /*HashMap<Character, Integer> map = new HashMap<>();
        int ans=0;
        for (int i=0,j=0;j<s.length();j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            else {
                map.put(s.charAt(j),j+1);//j+1 because when we find matching character just get it and assign to i
                ans = Math.max(ans,j-i+1);//difference of indexes +1
            }
        }
        return ans;*/

        /**
         * Java (Assuming ASCII 128)
         *
         * The previous implements all have no assumption on the charset of the string s.
         *
         * If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
         *
         * Commonly used tables are:
         *
         * int[26] for Letters 'a' - 'z' or 'A' - 'Z'
         * int[128] for ASCII
         * int[256] for Extended ASCII
         */
        int ans=0;
        int[] count = new int[128];
        for (int i=0,j=0;j<s.length();j++) {
            i = Math.max(count[s.charAt(j)], i);
            ans = Math.max(ans, j-i+1);
            count[s.charAt(j)] = j+1;
        }
        return ans;
    }



}
