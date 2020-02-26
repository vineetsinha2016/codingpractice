package com.vin.practise.leetcode.Amazon.oa;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in. There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to one of the treasure islands.
 *
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from one of the starting point (marked as S) of the map and can move one block up, down, left or right at a time.
 * The treasure island is marked as X. Any block with dangerous rocks or reefs will be marked as D.
 * You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in.
 * Output the minimum number of steps to get to any of the treasure islands.
 *
 * Example:
 *
 * Input:
 * [['S', 'O', 'O', 'S', 'S'],
 *  ['D', 'O', 'D', 'O', 'D'],
 *  ['O', 'O', 'O', 'O', 'X'],
 *  ['X', 'D', 'D', 'O', 'O'],
 *  ['X', 'D', 'D', 'D', 'O']]
 *
 * Output: 3
 * Explanation:
 * You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0).
 * Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 */
public class TreasureIsland2 {
    static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main (String[] args) {
        char[][] input = {
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        System.out.println("Result-->"+getMinPosition(input));
    }

    static int getMinPosition (char[][] input) {
        Queue<Position> queue = getAllS(input);//Get All S in matrix
        int steps=0;
        while (!queue.isEmpty()) {//start loop with S and keep looping until all covered
            steps++;
            for (int i=0;i<queue.size();i++) {//loop on queue
                Position p = queue.poll();
                System.out.println("the cordinates picked up from queue is :"+p.r + " and "+p.c);
                if (input[p.r][p.c]=='X') return steps; //since there are multiple X whichever reached first.
                input[p.r][p.c] = 'D'; //KEep marking as D (visited)
                for (int[] dir : DIRS) {
                    int nr = p.r + dir[0];
                    int nc = p.c + dir[1];
                    if (isValidToAdd(input, nr, nc)) {
                        queue.add(new Position(nr, nc));
                    }
                }
            }
        }
        return -1;
    }

    static Queue<Position>  getAllS (char[][] input) {
        Queue<Position> allS = new ArrayDeque<>();
        for (int i=0;i<input.length;i++) {
            for (int j=0;j<input[0].length;j++) {
                if (input[i][j]=='S') {
                    allS.add(new Position(i,j));
                }
            }
        }
        return allS;
    }
    static boolean isValidToAdd (char[][] input, int r, int c) {
        return r > 0 && r < input.length && c > 0 && c < input.length && input[r][c] != 'D';
    }
    static class Position {
        int r, c;
        Position(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
}
