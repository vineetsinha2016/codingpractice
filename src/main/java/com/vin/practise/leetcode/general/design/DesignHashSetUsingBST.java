package com.vin.practise.leetcode.general.design;

/**
 * Design Hash Set using Binary Search Tree
 *
 */
public class DesignHashSetUsingBST {
    /*private Bucket[] buckets;
    private Integer keyRange;*/
    /** Initialize your data structure here. */
    /*public DesignHashSetUsingBST() {
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
    }*/

    /** Returns true if this set contains the specified element */
    /*public boolean contains(int key) {
        int index = this._hash(key);
        return buckets[index].exists(key);
    }*/

   /* class Bucket {
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
    }*/
    //class MyBST {
        //private TreeNode root = null;
        /*public MyBST(int val) {//TODO :Learn the lesson . Not required
            this.root = new TreeNode(val);
        }*/
        /*public TreeNode searchMyBST (TreeNode root, int val) {
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
        }*/
        /**
         * to support delete node from BST we need following 2 methods :
         * findPredecessor and findSuccessor
         */
        //Formula ; One step left and then always right
        /*public int findPredecessor(TreeNode root) {
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
        }*/
   // }

        private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public DesignHashSetUsingBST() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new Bucket();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}


class Bucket {
    private BSTree tree;

    public Bucket() {
        tree = new BSTree();
    }

    public void insert(Integer key) {
        this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
    }

    public void delete(Integer key) {
        this.tree.root = this.tree.deleteNode(this.tree.root, key);
    }

    public boolean exists(Integer key) {
        TreeNode node = this.tree.searchBST(this.tree.root, key);
        return (node != null);
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class BSTree {
    TreeNode root = null;

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val)
            return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val > root.val)
            // insert into the right subtree
            root.right = insertIntoBST(root.right, val);
        else if (val == root.val)
            // skip the insertion
            return root;
        else
            // insert into the left subtree
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    /*
     * One step right and then always left
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    /*
     * One step left and then always right
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        // delete from the right subtree
        if (key > root.val)
            root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null)
                root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
