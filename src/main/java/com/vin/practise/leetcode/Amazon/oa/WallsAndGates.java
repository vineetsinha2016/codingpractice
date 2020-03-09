package com.vin.practise.leetcode.Amazon.oa;

import javafx.geometry.Pos;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates {

    static int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main (String[] args) {
        //2147483647
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647, -1},{2147483647,-1,2147483647,-1}, {0,-1,2147483647,2147483647}};
        System.out.println("INput::");
        for (int i=0;i<rooms.length;i++) {
            System.out.print("[");
            for (int j=0;j<rooms[0].length;j++) {
                System.out.print(" "+rooms[i][j]+(i==rooms.length-1 ?"," :" "));
            }
            System.out.print("]");
        }
        System.out.println("Calling walls And Gates::");wallsAndGates(rooms);
    }

    static void wallsAndGates(int[][] rooms) {
        Queue<Position> arrayDeque = new ArrayDeque<>();
        //Add all INFs/EMpty room into this
        boolean[][] seen = new boolean[rooms.length][rooms[0].length];
        for (int i=0;i<rooms.length;i++) {
            for (int j=0;j<rooms[0].length;j++) {
                if (rooms[i][j]==2147483647) {
                    arrayDeque.add(new Position(i,j));
                    seen[i][j]=true;
                }
            }
        }
        System.out.println("ArrayDequesSIZW -->"+arrayDeque.size());
        int counter=0;//counter++;
        while (!arrayDeque.isEmpty()) {
            counter++;
            Position pos = arrayDeque.poll();
            if (pos.r==0 && pos.c==0)
            System.out.println("working on :["+pos.r+"]["+pos.c+"]");
            //Should counter by here?
            //int counter=0;
            for (int i=0;i<arrayDeque.size();i++) {
                //int counter=0;
                //counter++;
                for (int[] dir : DIRS) {
                    //int counter=0;
                    int newRow = pos.r + dir[0];
                    int newCol = pos.c + dir[1];
                    if (pos.r==0 && pos.c==0) System.out.println("New rows and columns=["+newRow+"]["+newCol+"]");
                    if (isSafe(rooms, newRow, newCol) && !seen[newRow][newCol]) {
                        counter++;seen[newRow][newCol]=true;
                        if (pos.r==0 && pos.c==0) System.out.println("Inside is Safe and seen passed & counter==["+counter+"]");

                        if (rooms[newRow][newCol]==0) {
                            rooms[pos.r][pos.c]=counter;
                        }
                    }
                }
            }
        }
        System.out.println("Writer here at the end::"+arrayDeque.size());
        for (int i=0;i<rooms.length;i++) {
            System.out.print("[");
            for (int j=0;j<rooms[0].length;j++) {
                System.out.print(" "+rooms[i][j]+(i==rooms.length-1 ?"," :" "));
            }
            System.out.print("]");
        }
    }
    static boolean isSafe(int[][] grid, int r, int c ) {
        if (r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==0) {//or ==0
            return true;
        }
        return false;
    }
    public static class Position {
        int r,c;
        Position(int r, int c) {
            this.r =r;this.c=c;
        }
    }
}
