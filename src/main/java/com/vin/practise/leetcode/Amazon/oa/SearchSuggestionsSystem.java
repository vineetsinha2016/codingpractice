package com.vin.practise.leetcode.Amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests
 * at most three product names from products after each character of searchWord is typed.
 * Suggested products should have common prefix with the searchWord. If there are more than three products
 * with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 *
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 *
 * Example 4:
 *
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 *
 *
 * Constraints:
 *
 * 1 <= products.length <= 1000
 * There are no repeated elements in products.
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 */
public class SearchSuggestionsSystem {
    public static void main (String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println("Result -->" +suggestedProducts(products, searchWord));
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(3,(s1,s2)-> s1.compareTo(s2));
        for (int i=1;i<=searchWord.length();i++) {
            for (int j=0;j<products.length;j++) {
                if (products[j].startsWith(searchWord.substring(0,i))) {
                    pq.add(products[j]);
                }
            }
            List<String> temp = new ArrayList<>();
           for (int z=0;z<3;z++) {
               if (pq.peek()!=null)
                temp.add(pq.poll());
            }
            result.add(temp);
            pq.clear();
        }
        return result;//O(KV) -->K is length of searchword and V is length of products
    }
    /*static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans= new ArrayList<>();
        int N=searchWord.length();
        if (N==0) return ans;

        Arrays.sort(products);
        List<String> pool=Arrays.asList(products);
        for (int i=1;i<=N;i++) {
            String str=searchWord.substring(0,i);
            List<String> words=new ArrayList<>();
            pool.forEach(word->{if (word.startsWith(str)) words.add(word);});
            int e = (words.size()<3) ? words.size():3;
            ans.add(words.subList(0,e));
            pool=words;
        }
        return ans;
    }*/

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {
        return IntStream.rangeClosed(1, searchWord.length())
                .mapToObj(i -> searchWord.substring(0, i))
                .map(prefix -> Arrays.stream
                        (products)
                        .filter(product -> product.startsWith(prefix))
                        .sorted()
                        .limit(3)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

}
