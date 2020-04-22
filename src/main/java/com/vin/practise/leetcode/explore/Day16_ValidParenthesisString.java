package com.vin.practise.leetcode.explore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class Day16_ValidParenthesisString {
    public static void main (String[] args) {
        String s="(**())*)";//"()";//"(*))";
        System.out.println("Result-->"+checkValidString(s));
    }
    static boolean checkValidString(String s) {
        int leftBalance = 0;
        for (int i=0; i<s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
                leftBalance++;
            else
                leftBalance--;

            if (leftBalance<0) return false; // We know we have unbalanced parenthesis
        }

        // We can already check if parenthesis are valid
        if (leftBalance == 0) return true;

        int rightBalance = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
                rightBalance++;
            else
                rightBalance--;

            if (rightBalance<0) return false;  // We know we have unbalanced parenthesis
        }

        // Here we know we have never been unbalanced parsing from left to right e.g. ')('
        // We've also already substituted '*' either by '(' or by ')'
        // So we only have 3 possible scenarios here:
        // 1. We had the same amount of '(' and ')'
        // 2. We had more '(' then ')' but enough '*' to substitute
        // 3. We had more ')' then '(' but enough '*' to substitute
        return true;
        /*int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;*/

    }
}
