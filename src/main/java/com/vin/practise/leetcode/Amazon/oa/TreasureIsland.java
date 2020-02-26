package com.vin.practise.leetcode.Amazon.oa;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
 *
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the
 * top-left corner of the map and can move one block up, down, left or right at a time.
 * The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks.
 * You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe.
 * Output the minimum number of steps to get to the treasure.
 *
 * Example:
 *
 * Input:
 * [['O', 'O', 'O', 'O'],
 *  ['D', 'O', 'D', 'O'],
 *  ['O', 'O', 'O', 'O'],
 *  ['X', 'D', 'D', 'O']]
 *
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */
public class TreasureIsland {
    static int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main (String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'O'}, {'D', 'O', 'D', 'O'}, {'O', 'O', 'O', 'O'},{'X', 'D', 'D', 'O'}};
        System.out.println("Result-->"+minSteps(grid));
    }
    public static int minSteps(char[][] grid) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));
        grid[0][0]='D';
        int steps =0;
        while(!queue.isEmpty()) {
            steps++;
            for (int sz = queue.size(); sz > 0; sz--) {
                Point p = queue.poll();

                for (int[] dir : DIRS) {
                    int r = p.r + dir[0];
                    int c = p.c + dir[1];

                    if (isSafe(grid, r, c)) {
                        if (grid[r][c] == 'X') return steps;
                        grid[r][c] = 'D';
                        queue.add(new Point(r, c));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isSafe(char[][] grid, int r, int c ) {
        if (r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]!='D') {
            return true;
        }
        return false;
    }
    public static class Point {
        int r,c;
        Point(int r, int c) {
            this.r =r;this.c=c;
        }
    }
}