package com.vin.practise.leetcode.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Day6_GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};//{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Result -->"+groupAnagrams(strings));
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            Arrays.fill(chars, 0);
            for (int i=0;i<str.length();i++) {
                chars[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++) {
                sb.append("#").append(chars[i]);//create a unique key for each word coz duh and ill had a conflict
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
            //TODO : Learnt that duh and ill had same value of sum of ascii and that created problem
            /*if (str.equals("duh") || str.equals("ill")) {
                System.out.println("Ascii count of: "+str+" is -->"+asciiCount);
            }*/
        }
        return new ArrayList<>(map.values());
    }
}
