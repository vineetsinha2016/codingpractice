package com.vin.practise.leetcode.Amazon.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class Problem5_Most_Common_Word {
    //Algo:
    //Step 1: Remove punctuations from paragraph
    //Step 2: Paragraph.split(" ");
    //Step 3: go through this array and filter out banned words.
    //Step 4: store all words in hashmap with count <String, Integer>

    public static String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph!=null && paragraph.length()>1 && paragraph.length()<=1000 && banned!=null
                && banned.length>=0 && banned.length<=100) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
            HashSet<String> banSet = new HashSet<>();
            for (String ban:banned) {
                if (ban.length()>10) return null;
                banSet.add(ban);
            }
            for(String word:words) {
                if (banSet.contains(word)) continue;
                else {
                    if(!hashMap.containsKey(word)) {
                        hashMap.put(word, 1);
                    }
                    else {
                        hashMap.put(word, hashMap.get(word)+1);
                    }
                }
            }
            int max = 0;String maxKey = null;
            for (String key :hashMap.keySet()) {
                if (hashMap.get(key) >max) {
                    maxKey=key;max = hashMap.get(key);
                }
            }
            System.out.println("New paragraph::"+paragraph);
            System.out.println("Result is ::"+maxKey);
            return maxKey;
        }
        String[] punctuation = {"!","/?","'",";",",","."};
        //paragraph = removePunctuationsAndToLower(paragraph, punctuation,banned);

        /*String[] strings = paragraph.split(" ");
        int count =0;
        for(int i=0;i<strings.length;i++) {
            if (!hashMap.containsKey(strings[i])) {
                hashMap.put(strings[i], count);
            }
            else {
                hashMap.put(strings[i],++count);
            }
        }*/
        return null;
    }

    private static String removePunctuationsAndToLower(String paragraph, String[] punctuation, String[] banned) {
        for (int i=0;i<punctuation.length;i++) {
            if(paragraph.contains(punctuation[i])){
                System.out.println("this exists in Paragraph:" +
                        ""+punctuation[i]);
                paragraph = paragraph.replace(punctuation[i], "");
                System.out.println("punctuation[i]:"+punctuation[i]+"  New Paragraph inside loop:"+paragraph);
            }
        }
        paragraph = paragraph.toLowerCase();
        if (banned!=null)
            for (int i=0;i<banned.length;i++) {
                if(paragraph.contains(banned[i]))
                    paragraph = paragraph.replace(banned[i],"");
            }
        return paragraph;
    }

    public static void main (String[] args) {
        String paragraph = "a.";//"Bob hit a ball, the hit BALL flew far after it was hit.";//"a.";//
        String [] banned = {};//{"hit"};//{};//

            mostCommonWord(paragraph, banned);

    }
}
/**
 * Most important learning was use of REgex for split ----->>>>> paragraph.toLowerCase().split("[ !?',;.]+");
 * and use of HashSet with HashMap
 */
