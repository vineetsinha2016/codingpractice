package com.vin.practise.leetcode.Amazon.easy;

import java.util.*;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 * Example
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class Problem7_Rotting_Oranges {
    /*public static int orangesRotting(int[][] grid) {
        int hasOne = 0;int minutes = 0;
        for (int i=0;i<grid.length;i++) {
            System.out.println();
            for (int j=0;j<grid.length;j++) {
                System.out.print("grid[" + i + "][" + j + "]=" + grid[i][j] + "\t");
            }}
        System.out.println("\n\n");
        for (int i=0;i<grid.length;i++) {
            System.out.println();
            for (int j=0;j<grid.length;j++) {
                System.out.print("grid["+i+"]["+j+"]="+grid[i][j]+"\t");
                if (grid[i][j]==1) hasOne++;
                System.out.println("minutes-->"+minutes);
                if (!hasNeighbour(grid, i, j)) return -1;
                else {
                    if (grid[i][j]==2) {
                        minutes++;
                        System.out.println("minutes==>"+minutes);
                        if (j+1<grid.length){
                            grid[i][j+1] =2;
                        }
                        if (i+1<grid.length) {
                            grid[i+1][j]=2;
                        }
                        *//*if (i-1>=0) {
                            grid[i-1][j]=2;
                        }
                        if (j-1>=0) {
                            grid[i][j-1]=2;
                        }*//*

                    }
                }
            }
        }
        if (hasOne==0) return 0;
        return minutes;
    }*/
    static boolean hasNeighbour(int[][] grid, int i, int j) {
        System.out.println("hasNeighbour and grid[i][j]::"+grid[i][j]);
        boolean hasNeighbour = true;
        if (i+1<grid.length && grid[i+1][j]==0) {
            System.out.println("first loop");
            hasNeighbour = false;
        }
        if( j+1<grid.length && grid[i][j+1]==0) {
            System.out.println("second loop");
            hasNeighbour = false;
        }
        if (i-1>=0 && grid[i-1][j]==0) {
            System.out.println("third loop");
            hasNeighbour = false;
        }
        if( j-1>=0 && grid[i][j-1]==0) {
            System.out.println("fourth loop");
            hasNeighbour = false;
        }

        /*if (i+1<grid.length && j+1<grid.length) { //both are safe
            if (grid[i+1][j+1]!=0) hasNeighbour =true;
            if (grid[i][j+1]!=0) hasNeighbour = true;
            if (grid[i+1][j]!=0) hasNeighbour = true;
        }
        if (i-1>=0 && j-1>=0) { //both are safe
            if (grid[i-1][j-1]!=0) hasNeighbour =true;
            if (grid[i][j-1]!=0) hasNeighbour = true;
            if (grid[i-1][j]!=0) hasNeighbour = true;
        }
        if (i-1>=0 && j-1<0)
        return hasNeighbour;*/
        return true;//hasNeighbour;
    }
    static class O {
        int x ; int y ;
        int layer;
        public O(int x, int y, int layer){
            this.x = x; this.y = y; this.layer = layer;
        }
    }


        public static int orangesRotting(int[][] grid) {
            int R = grid.length; int C = grid[0].length;
            for (int i=0;i<grid.length;i++) {
                System.out.println();
                for (int j=0;j<grid.length;j++) {
                    System.out.print("grid[" + i + "][" + j + "]=" + grid[i][j] + "\t");
                }}
            //boolean[][] visited = new boolean[R][C];
            Queue<O> q = new ArrayDeque<>();
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(grid[i][j] == 2){
                        System.out.println("Adding 2s in queue");
                        q.add(new O(i, j, 0));
                    }
                }
            }

            int res = 0;
            while(!q.isEmpty()){
                System.out.println("getting elements out of queue");
                O cur = q.poll();
                System.out.println("Current element from queue is ::[x]:"+cur.x+" [y]:"+cur.y+" layer of it is cur.layer-->"+cur.layer);
                res = Math.max(res, cur.layer);
                System.out.println("Result till now compared to cur is : res--> "+res);
                System.out.println("** Now traverse in all 4 directions and find out what to do ***");
                //instead of writing 4 separate logic for calculating 4 directions and deciding based on value
                //Here with help of 2 integer arrays we do calculation in all directions. BRILLIANT
                for(int k = 0; k < x.length; k++){
                    int ro = cur.x + x[k];
                    System.out.println("x-cordinate neighbour ro::"+ro);
                    int co = cur.y + y[k];
                    System.out.println("y-cordinate neighbour co::"+co);
                    if(inside(grid, ro, co) && grid[ro][co] == 1) {
                        q.add(new O(ro, co,  cur.layer + 1));
                        grid[ro][co] = 2;
                    }
                }
            }

            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(grid[i][j] == 1){
                        return -1;
                    }
                }
            }

            return res;
        }

        static int[] x = {0,0,-1,1};//x - cordinates latitud e
        static int[] y = {-1,1,0,0}; // y - cordinates longitude

        public static boolean inside(int[][] grid, int i , int j){
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return  false;
            return true;
        }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Result-->"+orangesRotting(grid));
    }
    static int[] dr = new int[]{-1, 0, 1, 0};// four directions for row
    static int[] dc = new int[]{0, -1, 0, 1};//four directions for column
    /*public static int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        for (int i=0;i<grid.length;i++) {
            System.out.println();
            for (int j=0;j<grid.length;j++) {
                System.out.print("grid[" + i + "][" + j + "]=" + grid[i][j] + "\t");
            }}
        System.out.println("\n\n");
        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    System.out.println("This orange is rotten : position is :["+r+"]["+c+"]");
                    int code = r * C + c;
                    System.out.println("The value of code i.e r * C +c-->");
                    queue.add(code);
                    depth.put(code, 0);
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            System.out.println("COde removed from Queue::"+code);
            int r = code / C, c = code % C;
            System.out.println("value of r i.e code/C -->"+r);
            System.out.println("value of c i.e code % c -->"+c);
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                System.out.println("nr -->"+nr);
                int nc = c + dc[k];
                System.out.println("nc --->"+nc);
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }*/


}
