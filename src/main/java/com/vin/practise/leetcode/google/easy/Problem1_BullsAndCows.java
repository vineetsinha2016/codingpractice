package com.vin.practise.leetcode.google.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and
 * ask your friend to guess what the number is. Each time your friend makes a guess,
 * you provide a hint that indicates how many digits in said guess match your secret number exactly
 * in both digit and position (called "bulls") and how many digits match the secret number but locate
 * in the wrong position (called "cows"). Your friend will use successive guesses and hints to
 * eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 *
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class Problem1_BullsAndCows {
    public static void main(String[] args) {
        String secret = "1122",guess="2211";//"1807", guess = "7810";//"1123", guess = "0111";//"1234",guess="0111";//
        System.out.println("Result -->"+getHint(secret,guess));
    }
    private static String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();int countA=0, countB=0;
        int[] index = new int[10];//TODO: Trick here that these secret and guess are all numbers (0 to 9)
        for (int i=0;i<guess.length();i++) {
            if (guess.charAt(i)==secret.charAt(i)) countA++;
            /*else if (guess.contains(Character.toString(secret.charAt(i))))
            {countB++;}*/
            else {
                if (++index[secret.charAt(i)-'0']<=0) {//TODO: If Secret doesn't have any occurence of this
                    System.out.println("Secret.charAt(i)-->"+secret.charAt(i)+"** Incrementing becoz Plus/Secret digit is less than or equal to 0");
                    countB++;
                }
                if (--index[guess.charAt(i)-'0']>=0) {
                    System.out.println("guess.charAt(i)-->"+guess.charAt(i)+"** Incrementing becoz Minus/Gues digit is more than or equal to 0");
                    countB++;
                }
                /*int plus = ++index[secret.charAt(i) - '0'];
                System.out.println("plus="+plus+" secret.charAt(i):"+secret.charAt(i)+" - "+'0');
                int minus = --index[guess.charAt(i) - '0'];
                System.out.println("minus ="+minus+" guess.charAt(i):"+guess.charAt(i)+" - "+'0');
                if (plus <= 0) {
                    System.out.println("** Incrementing becoz Plus/Secret digit is less than or equal to 0");
                    countB++;
                }
                if (minus >= 0) {
                    System.out.println("** Incrementing becoz Minus/Gues digit is more than or equal to 0");
                    countB++;
                }*/
            }
        }
        System.out.println("Count:"+countB);
        sb.append(countA).append("A").append(countB).append("B");
        int count =0;
        for (int a : index) {
            System.out.println("Index -->"+count+" the value:"+a);
            count++;
        }
        return sb.toString();
    }
}
