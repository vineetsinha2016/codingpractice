package com.vin.practise.leetcode.general.design;

/**
 * Design Hash Set using Binary Search Tree
 *
 */
public class DesignHashSetUsingBST {
    private Bucket[] buckets;
    private Integer keyRange;
    /** Initialize your data structure here. */
    public DesignHashSetUsingBST() {
        this.keyRange=769;
        this.buckets = new Bucket[this.keyRange];
        for (int i=0;i<keyRange;i++) {
            buckets[i] = new Bucket();
        }
    }

    public int _hash(int key) {
        return this.keyRange%key;
    }
    public void add(int key) {
        int index = _hash(key);
        this.buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = this._hash(key);
        buckets[index].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = this._hash(key);
        return buckets[index].exists(key);
    }

    class Bucket {
        private MyBST myBST;
        public Bucket() {
            myBST = new MyBST();
        }
        public void insert (Integer key) {
            this.myBST.root = this.myBST.insertIntoMyBST(this.myBST.root, key);
        }
        public void delete (Integer key ) {
            this.myBST.root = this.myBST.deleteFromMyBST(this.myBST.root, key);
        }
        public boolean exists (Integer key) {
            TreeNode node = this.myBST.searchMyBST(this.myBST.root, key);
            return node!=null;
        }
    }
    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    class MyBST {
        private TreeNode root = null;
        /*public MyBST(int val) {//TODO :Learn the lesson . Not required
            this.root = new TreeNode(val);
        }*/
        public TreeNode searchMyBST (TreeNode root, int val) {
            if (root==null || val == root.val) return root;
            return (val<root.val)  ? searchMyBST(root.left, val)
            :  searchMyBST(root.right, val);
        }
        public TreeNode insertIntoMyBST(TreeNode root, int val) {
            if (root ==null) return new TreeNode(val);
            if (val>root.val) {//insert into right
                root.right = insertIntoMyBST(root.right, val);
            }
            else if (root.val==val) return root;
            else {///insert into left
                root.left = insertIntoMyBST(root.left, val);
            }
            return root;
        }
        /**
         * to support delete node from BST we need following 2 methods :
         * findPredecessor and findSuccessor
         */
        //Formula ; One step left and then always right
        public int findPredecessor(TreeNode root) {
            root = root.left;
            while (root.right!=null) root = root.right;
            return root.val;
        }
        //Formula : One step right and then always left
        public int findSuccessor (TreeNode root) {
            root = root.right;
            while (root.left!=null) root = root.left;
            return root.val;
        }
        public TreeNode deleteFromMyBST ( TreeNode root, int key) {
            if (root == null) return null;
            if (key>root.val) {
                root.right = deleteFromMyBST(root.right, key);
            }
            else if (key<root.val) {
                root.left = deleteFromMyBST(root.left, key);
            }
            else {//this is equal to root
                //a. if it doesn't have left or right tree
                if (root.left==null && root.right==null) root = null;
                else if (root.right!=null) {//since right tree will be greater than left one so first check right
                    root.val = findSuccessor(root);
                    root.right = deleteFromMyBST(root.right, root.val);
                }
                else {//since the tree doesn't have right tree so left one will have to become root now
                    root.val = findPredecessor(root);
                    root.left = deleteFromMyBST(root.left, root.val);
                }
            }
            return root;
        }
    }
}
