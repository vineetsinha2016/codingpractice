package com.vin.practise.leetcode.Amazon.oa;

import java.util.*;

/**
 * You work on a team whose job is to understand the most sought after toys for the holiday season.
 * A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles.
 * You need to take these quotes and identify which toys are mentioned most frequently.
 * Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.
 *
 * Your algorithm should output the top N toys mentioned most frequently in the quotes.
 *
 * Input:
 * The input to the function/method consists of five arguments:
 *
 * numToys, an integer representing the number of toys
 * topToys, an integer representing the number of top toys your algorithm needs to return;
 * toys, a list of strings representing the toys,
 * numQuotes, an integer representing the number of quotes about toys;
 * quotes, a list of strings that consists of space-sperated words representing articles about toys
 *
 * Output:
 * Return a list of strings of the most popular N toys in order of most to least frequently mentioned
 *
 * Note:
 * The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys,
 * return the names of only the toys mentioned in the quotes.
 * If toys are mentioned an equal number of times in quotes, sort alphabetically.
 *
 * Example 1:
 *
 * Input:
 * numToys = 6
 * topToys = 2
 * toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
 * numQuotes = 6
 * quotes = [
 * "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
 * "The new Elmo dolls are super high quality",
 * "Expect the Elsa dolls to be very popular this year, Elsa!",
 * "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
 * "For parents of older kids, look into buying them a drone",
 * "Warcraft is slowly rising in popularity ahead of the holiday season"
 * ];
 *
 * Output:
 * ["elmo", "elsa"]
 *
 * Explanation:
 * elmo - 4
 * elsa - 4
 * "elmo" should be placed before "elsa" in the result because "elmo" appears in 3 different quotes and "elsa" appears in 2 different quotes.
 */
public class TopNToys {
    public static void main (String[] args) {
        int numToys =6, topToys=2, numQuotes=6;
        List<String> toys = Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft");
        List<String> quotes = Arrays.asList("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season");
        System.out.println("Result -->"+topToys(numToys, topToys, toys, numQuotes, quotes));
    }
    static List<String> topToys (int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes) {
        //Task 1: to identify which toys are used in quotes most frequently
        //Task 2: Take the top toys out of quotes and return top N

        //Step 1: Create a hashmap with toyname as key and a list of Integers that will keep track of being used in quotes
        Map<String, List<Integer>> map = new HashMap<>();
        //Step 2: Put all the toys in hashmap with count 0
        for (String toy : toys) {
            map.put(toy, new ArrayList<>(Arrays.asList(0,0)));
        }
        //Collections.addAll(toys);
        //Step 3: split the quotes
        for (String quote :quotes) {
            //Step 3: Create a hashSet for all the toys
            Set<String> hashSet = new HashSet<>();//Fresh for each quote to count how many different quotes does the toy appear
            String[] splitQuote = quote.toLowerCase().split("\\W+");//all non-word characters besides[a-z,0-9]
            for (String sq : splitQuote) {
                if (!map.containsKey(sq)) {//this is none of the toy
                    //map.get(sq).set(0,1);
                    continue;
                }
                else {
                    map.get(sq).set(0,map.get(sq).get(0)+1);//increment the first element of list: this is total count of toys appearance
                    if (!hashSet.contains(sq)) {
                        map.get(sq).set(1,map.get(sq).get(1)+1);//increment the second element of the list: and then added to hash Set.
                        //hashSet and index 1 will decide how many quotes the toys did appear
                    }
                    System.out.println("adding this to hashSet-->"+sq);
                    hashSet.add(sq);
                }
            }
        }
        map.forEach((key, value) -> System.out.println("Key=" + key + " and Value=" + value));
        PriorityQueue<String> pq = new PriorityQueue<>((t1,t2) ->{
            if (!map.get(t1).get(0).equals(map.get(t2).get(0))) return map.get(t1).get(0)-map.get(t2).get(0);
            if (!map.get(t1).get(1).equals(map.get(t2).get(1))) return map.get(t1).get(1) - map.get(t2).get(1);
             return t1.compareTo(t2);
        });
        if (topToys > numToys) {
            for (String toy : map.keySet()) {
                if (map.get(toy).get(0)>0) pq.add(toy);
            }
        }
        else {
            for (String toy: toys) {
                pq.add(toy);
                if (pq.size() > topToys) pq.poll();
            }
        }
        List<String> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }
         Collections.reverse(output);
        return output;
    }
}
