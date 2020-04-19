package com.vin.practise.leetcode.explore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */
public class Day14_PerformStringShifts {

    public static void main (String[] args) {


        String s = "wpdhhcj";//"abcdefg";
        int[][] shift = {{0,7},{1,7},{1,0},{1,3},{0,3},{0,6},{1,2}};//{{1,1},{1,1},{0,2},{1,3}};//{{1,2}};//
        System.out.println("Result-->"+stringShift(s, shift));
    }
    static String stringShift(String s, int[][] shift) {
        int totalShift =0;
        for (int i=0;i<shift.length;i++) {
            int direction = shift[i][0];
            int amount = shift[i][1];
            if (direction==0) {
                //move left
                totalShift-=amount;
            }
            else {
                //move right
                totalShift+=amount;
            }
        }
        String front, back;
        if (totalShift>0) {
            totalShift = totalShift % s.length();
            front = s.substring(s.length()-totalShift);
            back = s.substring(0, s.length()-totalShift);
        }
        else if (totalShift < 0) {

            totalShift = Math.abs(totalShift % s.length());
            front = s.substring(totalShift);
            back = s.substring(0,totalShift);
        }
        else return s;
        return front+back;

    }
    static StringBuilder moveRightAndLeft(StringBuilder sb, int[] dirPos) {

        if (dirPos[0]==1) { //move right
            Map<Character,Integer> chars = new HashMap<>();
            System.out.println("Dirpos[1]:"+dirPos[1]);
            for (int i=0;i<dirPos[1];i++) {
                System.out.println("sb.length()-1-i-->"+(sb.length()-1-i));
                chars.put(sb.charAt(sb.length()-1-i),sb.length()-1-i);
            }
            for (Integer i : chars.values())
            {
                System.out.println("Deleteing char at :"+i+" i.e "+sb.charAt(i));
                sb.deleteCharAt(i);
            }
            sb.replace(0,sb.length()+chars.size(), chars.toString()+sb.toString());
            System.out.println("sbafter modification::"+sb);
            //sb.deleteCharAt()//sb.replace()
        }
        /*else {//move left

        }*/
        return sb;
    }
}
