package com.vin.practise.leetcode.explore;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class Day9_BackspaceStringCompare {
    public static void main (String[] args) {
        String s = "mdamdluynq###########m#epymatjzksasf#";//"y#fo##f";//"a#c";//"a##c";//"ab##";//"ab#c";
        String t = "mdamdluynq###########m#epymatjzksa#sf#";//"y#f#o##f";//"b";//"#a#c";//"c#d#";//"ad#c";
        System.out.println("Result-->"+backspaceCompare(s, t));
    }
    static boolean backspaceCompare(String S, String T) {
        return getOnStack(S).equals(getOnStack(T));
    }

    private static String getOnStack(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<S.length();i++) {
            if (S.charAt(i)!='#') stack.push(S.charAt(i));
            else if (!stack.isEmpty()) stack.pop();
        }
        return String.valueOf(stack);
    }
}
