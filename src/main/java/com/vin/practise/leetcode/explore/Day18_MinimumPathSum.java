package com.vin.practise.leetcode.explore;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Day18_MinimumPathSum {
    static int[][] DIRS = {{0,1},{1,0}};
    public static void main (String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("result-->"+minPathSum(grid));
    }
    static int minPathSum(int[][] grid) {
        // THIS IS Dynamic Programming Implementation
        if (grid==null || grid.length==0) return 0;
        int result = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                //add to new matrix whatever is in the original one
                dp[i][j]+=grid[i][j];
                if (i>0 && j>0) { //this means we have to calculate which one will make our value lesser above or right
                    dp[i][j]+= Math.min(dp[i-1][j],dp[i][j-1]);
                }
                else if (i>0) {//j is 0 i.e. first column
                    dp[i][j]+= dp[i-1][j];
                }
                else if (j>0) { // i is 0 i.e. first row
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
    static boolean isSafe(int r, int c, int[][] grid) {
        if (r>=0 && r<grid.length && c>=0 && c<grid[0].length) {
            return true;
        }
        return false;
    }
    static class Position {
        int r;
        int c;
        Position(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}
