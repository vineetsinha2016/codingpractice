package com.vin.practise.leetcode.Amazon.oa;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class SearchA2DMatrix2 {
    public static void main (String[] args) {
        int[][] matrix ={{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        System.out.println("Result -->"+searchMatrix(matrix, 5));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        //Step 1: Start from first column last row
        int row = matrix.length-1;
        int col = 0;
        //RUn a loop . row is started at last and col at 0
        while (row>=0 && col<matrix[0].length) {
            //Step 2: if target is less than current value reduce the row
            if (matrix[row][col]>target) {
                row--;
            }
            //if target is more than current value increase the column
            else if (matrix[row][col]<target) {
                col++;
            }
            else return true;
        }
        return false;
    }
    /**
     * Complexity Analysis
     *
     * Time complexity : O(n+m)
     *
     * The key to the time complexity analysis is noticing that, on every iteration
     * (during which we do not return true) either row or col is is decremented/incremented exactly once.
     * Because row can only be decremented mm times and col can only be incremented nn times before causing
     * the while loop to terminate, the loop cannot run for more than n+mn+m iterations.
     * Because all other work is constant, the overall time complexity is linear
     * in the sum of the dimensions of the matrix.
     *
     * Space complexity : O(1)
     *
     * Because this approach only manipulates a few pointers, its memory footprint is constant.
     */
}
