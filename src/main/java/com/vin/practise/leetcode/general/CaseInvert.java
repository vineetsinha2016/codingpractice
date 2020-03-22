package com.vin.practise.leetcode.general;

import java.util.Arrays;

/**
 * Given a string s ="Hello"; return "hELLO"
 */
public class CaseInvert {
    public static void main (String[] args) {
        String s ="Hello";
        System.out.println("Result -->"+invertCase(s));
    }
    static String invertCase(String s) {
        //Idea we can loop through each word and see if each character falls under 'z'-'a' .
        //if not, they it is capital and we need to make it to lower case
        //if it does, then convert to uppercase
        //Step 1: change string to char array,
        //Step 2: loop through the array and check if the character value is between a and z
        //Step 3: if it does change the case or make a point to change the case to lower
        //Step 4: else change it to upper.. Here check no special characters.
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (chars[i] <='z' && chars[i]>='a') {
                chars[i]=Character.toUpperCase(chars[i]);
            }
            else if (chars[i]>='A' && chars[i]<='Z') {
                chars[i]=Character.toLowerCase(chars[i]);
            }
        }
        return Arrays.toString(chars);

    }
}
