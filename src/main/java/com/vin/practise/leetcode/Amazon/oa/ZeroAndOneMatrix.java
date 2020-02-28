package com.vin.practise.leetcode.Amazon.oa;

import javafx.geometry.Pos;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *  Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroAndOneMatrix {
    static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main (String[] args) {
        int[][] input = {{0,0,0},{0,1,0},{1,1,1}};
        printMatrix(input);
        int[][] output = getDistance(input);
        printMatrix(output);
    }

    private static void printMatrix(int[][] input) {
        System.out.print("{");
        Arrays.stream(input).forEach(x-> {
            System.out.print("{");
            for (int i=0;i<input.length;i++) {
                System.out.print(x[i]+(i!=input.length-1?",":""));
            }
            System.out.print("}");
        });
        System.out.println("}");
    }

    static int[][] getDistance (int[][] input) {
        Queue<Position> queue = getAllOnes(input);
        while (!queue.isEmpty()) {
            for (int i=0;i<queue.size();i++) {
                Position p = queue.poll();
                System.out.println("the cordinates of element from queue -->"+p.r +" and "+p.c);
                if (input[p.r][p.c]==0) {
                    ++input[p.r][p.c];
                    return input;//
                }
                for (int[] dir : DIRS) {
                    int nr = p.r + dir[0];
                    int nc = p.c + dir[1];
                    if (isSafeToAdd(input, nr, nc)){
                        System.out.println("Add in quue:"+nr +" & "+nc+" input[nr][nc]->"+input[nr][nc]);
                        //++input[nr][nc];
                        System.out.println(" input[nr][nc]->"+input[nr][nc]);
                        queue.add(new Position(nr, nc));
                    }
                }
            }
        }
        return input;
    }
    static Queue<Position> getAllOnes (int[][] input) {
        Queue<Position> allOnes = new ArrayDeque<>();
        for (int i=0;i<input.length;i++) {
            for (int j=0;j<input[0].length;j++) {
                if (input[i][j]==1) {
                    allOnes.add(new Position(i,j));
                }
            }
        }
        return allOnes;
    }
    static boolean isSafeToAdd (int[][] input, int r , int c) {
        if (r>=0 && r<input.length && c>=0 && c<input[0].length && input[r][c]==0) {
            return true;
        }
        return false;
    }
    static class Position {
        int r, c;
        Position (int r , int c) {
            this.r = r;
            this.c =c;
        }
    }
}
