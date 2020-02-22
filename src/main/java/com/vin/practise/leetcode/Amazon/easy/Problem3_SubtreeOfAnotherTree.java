package com.vin.practise.leetcode.Amazon.easy;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and
 * node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 *  * Definition for a binary tree node.
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 */
public class Problem3_SubtreeOfAnotherTree {
    static  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        /**
         * Wrong Algorithm :
         * Step 1: Take first target node and search the main tree. If not found return false;
         * Step 2: If found, check if target node has left and right node,
         *          2a. if yes, then compare with main left and right node. If equal return true else false
         *          2b. if no, then main tree node should also not have the left and right node. return true;
         * Step 3: if reached here then do above step for both left and right nodes.
         * Terminate when any target node is null;-----> This step couldn't be achieved
         */

        /**
         * Right algo:
         * Idea is to create each node as root node and compare its right and left nodes
         * Step 1: create a method to traverse through s
         * Step 2 : from traverse method call isEqual method that will check s with the target node value
         * Step 3: if value is not equal then keep comparing left and right of the node.
         */
        boolean result = false;
        //TreeNode temp = s;
        return traverse(s, t);
        /*Boolean x = isEqual(s, t);
        if (x != null) return x;*/

        //}
        /*while (temp!=null && t!=null) {
            if (temp.val == t.val) {
                if (temp.left!=null && t.left!=null && temp.right!=null && t.right!=null) {
                    if (temp.left.val==t.left.val && temp.right.val==t.right.val) {
                        result = true;
                    }
                }
                else if (temp.left==null && t.left==null && temp.right==null && t.right==null ){
                    result = true;
                }
                else {
                    result =false;
                }
                temp = temp.left;t = t.left;

            }
            else {
                result =false;
                temp = temp.left;
            }
        }*/
        //return result;
    }

    private static boolean traverse (TreeNode s, TreeNode t) {
        if (s!=null) {
            return isEqual(s, t) || traverse(s.left, t) || traverse(s.right, t);
        }
        return false;
    }
    private static boolean isEqual(TreeNode s, TreeNode t) {
        if (s==null && t==null) {
            return true;
        }
        if (s==null || t==null) {
            return false;
        }
        if (s.val==t.val) {
            System.out.println("comparing s and t ::"+s.val +" and t:"+t.val);
            return isEqual(t.left, s.left) && isEqual(t.right, s.right);
        }
        return false;
    }

    private static boolean compareRighLeft(TreeNode t, TreeNode temp) {
        if (temp.right!=null && temp.left!=null && t.left!=null && t.right!=null) {
            if (temp.left.val==t.left.val && temp.right.val==t.right.val) {
                System.out.println("returning true when all nodes are equal ");
                return true;
            }
            else return false;
        }
        else if (temp.left==null && t.left==null && temp.right==null && t.right==null ){
            System.out.println("returning true when all nodes null ");
            return true;
        }
        else {
                return false;
        }
    }

    public static void main (String[] args) {
        TreeNode s = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        s.left = left;
        s.right = right;
        left.left = new TreeNode(1);
        left.right =new TreeNode(2);//[3,4,5,1,2,null,null,0]
        //left.right.left = new TreeNode(0);
        System.out.println("PRINTING THE TREE S");
        printBinaryTree(s);
        /*TreeNode s = new TreeNode(4);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        s.left = left;
        s.right = right;*/

        TreeNode t = new TreeNode(4);
         left = new TreeNode(1);
         right = new TreeNode(2);
        t.left = left;
        t.right = right;

        System.out.println("PRINTING THE TREE T");
        printBinaryTree(t);
        System.out.println("REsult ::"+isSubtree(s, t));
    }
    static void printBinaryTree (TreeNode t) {
        //TreeNode temp = t;
        if (t!=null) {
           // if (t.left!=null && t.right!=null) {
                System.out.println("**"+t.val+"**");
                //optional below starts
                if (t.left!=null) System.out.println("*" + t.left.val);
                if (t.right!=null) System.out.println(" "+t.right.val+"*");
                //optional ends
            printBinaryTree(t.left);
            printBinaryTree(t.right);
        }

    }
}
