package com.vin.practise.leetcode.explore;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Day11_DiameterOfBinaryTree {
    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(3);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        System.out.println("Result-->" + diameterOfBinaryTree(head));
    }

    static int ans;
    static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    static int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
    //find distance between one leaf node to other
    /*static int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            traverse(root);
        }
        return diameter;
    }*/

    static int traverse(TreeNode node) {
        if (node == null) return 0;
        int depthOfLeftAndRight = Math.max(traverse(node.left) , traverse(node.right));
        diameter = Math.max(diameter, depthOfLeftAndRight+1);
        return diameter;
    }
    //return diameter;
    //base case: if node.right and node.left both null i.e this is leaf node
        /*if (node==null || (node.right==null && node.left==null)) return diameter;
        else {
            diameter++;
            //diameter+=Math.max(traverse(node.left), traverse(node.right));
        }
        return node.left!=null ? traverse(node.left) : traverse(node.right);*/
//}
    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
