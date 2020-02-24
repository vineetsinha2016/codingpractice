package com.vin.practise.leetcode.Amazon.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ou have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class Problem6_Reorder_Data_Log_Files {
    public static String[] reorderLogFiles(String[] logs) {
        //sort and compare each elements
        Arrays.sort(logs,(a,b)-> {
            //split into two parts : Key and remaining string
            final String[] split1 = a.split(" ", 2);
            final String[] split2 = b.split(" ", 2);
            //find out if the splitted ones are letter or digit
            final boolean digit1 = Character.isDigit(split1[1].charAt(0));
            final boolean digit2 = Character.isDigit(split2[1].charAt(0));
            if (digit1 && digit2){//both contain digits
                return 0;//same order will do
            }
            else if (!digit1 && digit2) {//second contains digits
                return -1;//maintain same order
            }
            else if (digit1 && !digit2){ //first one contains digits
                return 1;//second one goes before
            }
            //now both are strings so we need to compare strings both a and b
            else {
                int compare = split1[1].compareTo(split2[1]);
                // if first string == second string, return identifier comparator
                return compare == 0 ?  split1[0].compareTo(split2[0]) : compare;
            }
        });
        /*Pattern pattern = Pattern.compile("\\d+");
        HashMap<String, String> letterMap = new HashMap<>();
        HashMap<String, String> digitMap = new HashMap<>();
        ArrayList<String> letterStr = new ArrayList<>();
        for (int i=0;i<logs.length;i++) {
            final String[] split = logs[i].split(" ", 2);
            //for (int j=0;j<split.length;j++) {
                System.out.println("split["+0+"]::"+split[0]);
            System.out.println("split["+1+"]::"+split[1]);
            //}
            Matcher m = pattern.matcher(split[1]);
            if (m.find()) {
                System.out.println("Digits found ion "+split[1]);
                digitMap.put(split[0],split[1]);
            }
            else {
                letterMap.put(split[0],split[1]);letterStr.add(split[1]);
            }
        }*/
        return logs;
    }
    public static void main(String[] args){
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        logs = reorderLogFiles(logs);
        for (String log : logs) {
            System.out.println(" log-->"+log);
        }
    }
}
/**
 * Learnings :
 * 1. How to use compare to of string (0 means same order(equal), 1 means first string was bigger(that is met condition) and -1 means second string met condition
 * 2. How to use split({expression}, limit)
 * 3. How to understand more complexity(as in first solution) results in wrong direction
 */
