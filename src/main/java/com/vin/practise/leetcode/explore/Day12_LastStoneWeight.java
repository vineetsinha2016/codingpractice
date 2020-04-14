package com.vin.practise.leetcode.explore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class Day12_LastStoneWeight {
    public static void main(String[] args) {
        int[] stones =  {2,7,4,1,8,1};
        System.out.println("Result-->"+lastStoneWeight(stones));
    }
    static int lastStoneWeight(int[] stones) {
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int i=0;i<stones.length;i++) {
            queue.add(stones[i]);
        }
        for (int i=0;i<queue.size();i++){
            System.out.println("ABD-->"+queue.peek());
        }
        while(queue.size()>1) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            if (a>b) {
                queue.add(a-b);
            } else if (b>a) queue.add(b-a);
        }

        return queue.size()>0 ? queue.remove() : result;
    }
}
