package com.vin.practise.leetcode.Amazon.easy;

import java.util.Arrays;

/***
 * Given an array A of integers and integer K, return the maximum S such that there
 * exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 *
 * Example 1:
 *
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * Example 2:
 *
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 1000
 * 1 <= K <= 2000
 */
public class Problem8_TwoSumLessThanK {
    public static void main (String[] args) {
        int[] ints = /*{114,169,633,838,883,265,221,966,389,503,393,260,431,316,261,220,642,664,413,401,150,150,474,558,
                667,61,152,222,769,768,718,733,728,359,104,108,496,132,184,985,387,487,961,389,702,547,115,164,388,318};*/
        {254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};

        //{100};//{10,20,30};//{34,23,1,24,75,33,54,8};//{32,45,1,11,32,56,-1,4};
        int sum =200; //100;//200;//15;//60;//64
        System.out.println("Result -->"+twoSumLessThanK(ints, sum));
        /*int max =0;int n=2;
        //i<j and max of ints[i] + ints[j] should be closest to 64
        // sliding window n=2
        if (n<=ints.length)
            for (int i=0;i<n;i++) {
                max += ints[i];
            }
        int window_sum = max<sum ? max : 0;
        for (int i=n;i<ints.length;i++) {

            int temp = window_sum + (ints[i] - ints[i-n]);
            window_sum = temp<sum ? Math.max(window_sum, temp) : window_sum;
            if (window_sum==98) {
                System.out.println("i-n-->"+(i-n)+" i:"+i+" n:"+n);
            }
        }
        System.out.println("max --> "+max);
        System.out.println("window_sum -->"+(window_sum==0 ? -1 : window_sum));*/

    }

    static int twoSumLessThanK(int[] A, int K) {
       /* int i = 0, j = A.length - 1, S = -1;

        Arrays.sort(A);

        while (i < j) {
            int sum = A[i] + A[j];

            if (sum < K) {
                S = Math.max(S, sum);
                i++;
            } else{
                j--;
            }
        }
        return S;*/
        int max=0; int i=0,j=A.length-1;
        Arrays.sort(A);
        while (max < K && i<j) {
            int temp = A[i]+A[j];
            if (temp<K) {
                max = Math.max(temp, max);
                System.out.println("Max ="+max);
                i++;
            }
            else  j--;

        }
        return (max!=0 ? max : -1);
    }
}
