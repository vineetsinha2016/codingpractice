package com.vin.practise.leetcode.explore;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 */
public class Day10_MinStack {
    public static void main (String [] args) {
         MinStack minStack = new MinStack();
        System.out.println("minStack.push(-2)-->");minStack.push(-2);
          minStack.push(0);
          minStack.push(-3);
        System.out.println("minStack.getMin()-->"+minStack.getMin());  // --> Returns -3.
        System.out.println("minStack.pop-->");                minStack.pop();
        System.out.println("minStack.top()-->"+minStack.top());      //--> Returns 0.
        System.out.println("minStack.getMin()-->"+minStack.getMin());                ;  // --> Returns -2.
    }
    static class MinStack {
        private Stack<int[]> stack = new Stack<>();
        public MinStack(){}
        public void push(int i) {
            if (stack.isEmpty()) {
                stack.push(new int[]{i,i});
                return;
            }
            stack.push(new int[]{i, Math.min(i, stack.peek()[1])});
        }
        public int pop() {
            if (stack.isEmpty()) return 0;
            return stack.pop()[0];
        }
        public int top()
        {
            return stack.peek()[0];
        }
        public int getMin() {
            return stack.peek()[1];
        }
    }
}
