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
        int A[] = {1, 7, 2, 3, 6, 7, 6, 7};//{1,2};//{7,1,5,3,6,4};//{7,6,4,3,1};//{2,4,1};//{7,6,8,0,-1,5};//
        System.out.println("Result --->"+maxProfit(A));
    }

    public static int maxProfit(int[] prices) {
        /**
         * Approach 3: Simple One Pass
         * Algorithm
         *
         * This solution follows the logic used in Approach 2 itself, but with only a slight variation.
         * In this case, instead of looking for every peak following a valley, we can simply go on crawling over
         * the slope and keep on adding the profit obtained from every consecutive transaction.
         * In the end,we will be using the peaks and valleys effectively, but we need not track the costs
         * corresponding to the peaks and valleys along with the maximum profit, but we can directly keep on
         * adding the difference between the consecutive numbers of the array if the second number is larger
         * than the first one, and at the total sum we obtain will be the maximum profit.
         * This approach will simplify the solution. This can be made clearer by taking this example:
         *
         * [1, 7, 2, 3, 6, 7, 6, 7]
         */
        int maxProfit = 0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i]>prices[i-1]) {
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
    /***
     * Learning : use Integer.MAX_VALUE when you want to keep minimum
     */
}
