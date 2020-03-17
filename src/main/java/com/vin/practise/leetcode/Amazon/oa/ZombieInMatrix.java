package com.vin.practise.leetcode.Amazon.oa;

import java.util.*;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent
 * (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
 *
 * Example:
 *
 * Input:
 * [[0, 1, 1, 0, 1],
 *  [0, 1, 0, 1, 0],
 *  [0, 0, 0, 0, 1],
 *  [0, 1, 0, 0, 0]]
 *
 * Output: 2
 *
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [0, 1, 0, 1, 1],
 *  [1, 1, 1, 0, 1]]
 *
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1],
 *  [1, 1, 1, 1, 1]]
 *
 *
 */
public class ZombieInMatrix {

    static int [] [] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main (String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 1, 1, 0, 1));
        grid.add(Arrays.asList(0, 1, 0, 1, 0));
        grid.add(Arrays.asList(0, 0, 0, 0, 1));
        grid.add(Arrays.asList(0, 1, 0, 0, 0));
        //System.out.println("[");
        grid.forEach(x->{
            System.out.print("["+x);
        });
        System.out.println("]");
        System.out.println("Result-->"+minHours(grid.size(), grid.get(0).size(), grid));
    }

    static int minHours(int rows, int columns, List<List<Integer>> grid) {
        int result =0, count=0, target=rows*columns;//take the measurement of matrix.
        //Goal here is to keep changing adjacent 0s to ones until all become 1s.
        // Step 1 : Use Array Deque to keep all the ones in it
        Queue<Position> arrayDeque = new ArrayDeque<>();
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                if (grid.get(i).get(j)==1) {
                    arrayDeque.add(new Position(i, j));
                    count++;
                }
            }
        }
        System.out.println("Initial Count ="+count+ "and target="+target);
        //Step 2 :loop on the Array Deque and take the elements out and try to process
        while (!arrayDeque.isEmpty()) {
            if (count==target) return result;//This is termination condition. This is to return the result as soon as we make everything 1
            for (int i=0;i<arrayDeque.size();i++) {
                Position  ad = arrayDeque.poll();//this will remove the element from arrayDeque
                for (int[] dir : DIRS) {
                    int newr = ad.r + dir[0];
                    int newc = ad.c + dir[1];
                    if (isSafe(grid, newr, newc)) {
                        count++;
                        grid.get(newr).set(newc, 1);
                        arrayDeque.add(new Position(newr, newc));//This will add new 1s into the matrix.
                    }
                }
            }
            result++;//increment result after every for loop (since all change will be simultaneous in an hour
        }
        grid.forEach(x->{
            System.out.print("["+x);
        });
        System.out.println("]");
        return result;
    }

    static boolean isSafe (List<List<Integer>> grid, int r, int c) {
        if (r>=0 && r<grid.size() && c>=0 && c <grid.get(0).size() && grid.get(r).get(c)!=1) {
            return true;
        }
        return false;
    }
    static class Position {
        int r, c;
        Position(int r, int c) {
            this.r = r;
            this.c =c;
        }
    }

}
