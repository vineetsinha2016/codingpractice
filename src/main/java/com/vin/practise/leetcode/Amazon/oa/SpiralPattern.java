package com.vin.practise.leetcode.Amazon.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralPattern {
    public static void main (String[] args) {
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};//{{1,2,3},{4,5,6},{7,8,9}};//
        System.out.println("Result-->"+createPattern(matrix));
    }
    static List<Integer> createPattern (int[][] matrix) {
        //Idea is to go first row then last column then last row and then first column
        List<Integer> result = new ArrayList<>();
        int firstRow =0,lastRow=matrix.length-1;
        int firstColumn = 0, lastColumn =matrix[0].length-1;
        while (firstRow<=lastRow && firstColumn<=lastColumn) {
            //first row
            for (int i=firstColumn;i<=lastColumn;i++) {
                result.add(matrix[firstRow][i]);
            }
            firstRow++;
            //last column
            for (int i=firstRow;i<=lastRow;i++) {
                result.add(matrix[i][lastColumn]);
            }
            lastColumn--;
            //last Row
            //now you need to check condition too
            if (firstRow<=lastRow) {
                for (int i=lastColumn;i>=firstColumn;i--) {
                    result.add(matrix[lastRow][i]);
                }
            }
            lastRow--;
            //first column
            //condition here too
            if (firstColumn<=lastColumn) {
                for (int i=lastRow; i>=firstRow;i--) {
                    result.add(matrix[i][firstColumn]);
                }
            }
            firstColumn++;
        }
        return result;
    }
}
