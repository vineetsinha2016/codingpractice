package com.vin.practise.leetcode.explore;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Day17_NumberOfIslands {
    static int[][] DIRS={{0,1},{0,-1},{1,0},{1,-1}};
    public static void main (String[] args){
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println("Result-->"+numIslands(grid));
    }
    static  int numIslands(char[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int numOfIslands=0;
        Queue<Position> deque = new ArrayDeque<>();
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    deque.add(new Position(i, j));
                }
                while(!deque.isEmpty()) {
                    Position p = deque.poll();
                    for (int[] dir : DIRS) {
                        int nr = p.r + dir[0];
                        int nc = p.c + dir[1];
                        if (isSafe(nr, nc, grid)) {
                            deque.add(new Position(nr, nc));
                            grid[nr][nc]='0';
                        }

                    }
                }
            }
        }
        return numOfIslands;
    }
    static boolean isSafe (int r, int c, char[][] grid) {
        if (r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1') {
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
