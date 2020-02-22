package com.vin.practise.leetcode.Amazon.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Input: "()"
 * Output: true
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Input: "(]"
 * Output: false
 *
 * Input: "([)]"
 * Output: false
 *
 * Input: "{[]}"
 * Output: true
 */
public class Problem4_ValidParentheses {
     private static boolean isValid(String s) {
         if (s!=null) {
             if (s.trim().equals("")) return true;
             HashMap<Character, Character> hashMap = new HashMap<>();
             hashMap.put('(',')');hashMap.put('{','}');hashMap.put('[',']');
             Stack<Character> stack = new Stack<>();
             char[] characters = s.toCharArray();
             for (int i =0;i<s.length();i++) {
                 if (hashMap.containsKey(characters[i])) {
                     stack.push(characters[i]);
                 }
                 else {
                     if (stack.empty()) return false;
                     if (!hashMap.get(stack.pop()).equals(characters[i])) {
                         return false;
                     }
                 }
             }
             if (!stack.empty()) {
                 System.out.println("something left behind");
                    return false;
             }
         }
        return true;
    }
    public static void main(String [] args) {
        String str = "]";
        System.out.println("Result -->"+isValid(str));
    }
}
