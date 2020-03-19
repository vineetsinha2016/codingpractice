package com.vin.practise.leetcode.Amazon.oa;

import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
public class SpiralMatrix2 {
    public static void main (String[] args) {
        int[][] result = generateMatrix(1);
        for (int i=0;i<1;i++)
        System.out.println("Result -->"+ Arrays.toString(result[i]));
    }
    static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int firstRow = 0;
        int lastCol = n - 1;
        int lastRow = n - 1;
        int firstCol = 0;
        int v = 1;
        while (firstRow <= lastRow && firstCol <= lastCol) {
            // first row
            for (int i = firstCol; i <= lastCol; i++)
                matrix[firstRow][i] = v++;
            firstRow++;
            // last column
            for (int i = firstRow; i <= lastRow; i++)
                matrix[i][lastCol] = v++;
            lastCol--;
            // last row
            if (firstRow <= lastRow) {
                for (int i = lastCol; i >= firstCol; i--)
                    matrix[lastRow][i] = v++;
                lastRow--;
            }
            // first column
            if (firstCol <= lastCol) {
                for (int i = lastRow; i >= firstRow; i--)
                    matrix[i][firstCol] = v++;
                firstCol++;
            }
        }
        return matrix;
    }
    /**
     * Complexity O(n) --> idea is to go first row then last column(minus firstrow) then last row(minus last column)
     *                      then firstcolumn(minus last row)
     *                      Brackets minus are already covered.
     *                      Now repeat till row and column are same
     */
}
