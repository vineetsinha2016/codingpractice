package com.vin.practise.leetcode.Amazon.easy;

import java.util.HashMap;

/***
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Problem9_BestTimeBuySellStock {
    public static void main (String[] args) {
        int A[] = {1,2};//{7,1,5,3,6,4};//{7,6,4,3,1};//{2,4,1};//{7,6,8,0,-1,5};//
        System.out.println("Result --->"+maxProfit(A));
    }

    public static int maxProfit(int[] prices) {
        //Thought I have to decide the ith day when we should sell the stocks
        /*int  highest=0;int lowest=0;int day=0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<prices.length;i++) {
            hashMap.put(prices[i],i+1);
            if (i==0) lowest=prices[i];
            else if(lowest>prices[i]) lowest =prices[i];
            //lowest=Math.min(lowest, prices[i]);
            if(hashMap.containsKey(lowest) && i>hashMap.get(lowest)-1){
                highest = Math.max(highest,prices[i]);
            }
            else {
                highest=0;
            }
        }
        if (highest!=0) return hashMap.get(highest);
        System.out.println("Highest-->"+highest);
        System.out.println("lowest--->"+lowest);
        return day;*/
        int lowest= 0;/*Integer.MAX_VALUE;*/int maxProfit =0;
        for (int i=0;i<prices.length;i++) {
            if (i==0) lowest=prices[i];
            else if (prices[i] < lowest) {
                lowest = prices[i];
            }
            else if (prices[i]-lowest > maxProfit) {
                maxProfit = prices[i]-lowest;
            }
        }
        return maxProfit;
    }
    /***
     * Learning : use Integer.MAX_VALUE when you want to keep minimum
     */
}
