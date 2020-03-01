package com.vin.practise.leetcode.Amazon.oa;

import java.util.Arrays;

/**
 * Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k distinct characters. If the given string doesn't have k distinct characters, return 0.
 * https://leetcode.com/problems/subarrays-with-k-different-integers
 *
 * Example 1:
 *
 * Input: s = "pqpqs", k = 2
 * Output: 7
 * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
 * Example 2:
 *
 * Input: s = "aabab", k = 3
 * Output: 0
 * Constraints:
 *
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 */
public class SubstringsExactlyKDistinctChars {

    /*static int subarraysWithKDistinct(int[] A, int K) {

    }*/
    public static void main(String[] args)
    {
        String ch = "aabab";//"pqpqs";//"abcbaa";
        int k = 3;//2;//3;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + countkDist(ch, k));
    }

    // Function to count number of substrings
    // with exactly k unique characters
    static int countkDist(String str, int k)
    {
        // Initialize result
        int res = 0;

        int n = str.length();

        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            int dist_count = 0;

            // Initializing count array with 0
            Arrays.fill(cnt, 0);

            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;

                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;

                // If distinct character count becomes k,
                // then increment result.
                if (dist_count == k)
                    res++;
            }
        }

        return res;
    }
}
