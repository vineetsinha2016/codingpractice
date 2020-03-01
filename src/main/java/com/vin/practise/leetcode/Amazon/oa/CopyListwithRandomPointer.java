package com.vin.practise.leetcode.Amazon.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 *
 *
 * Example 1:
 *
 Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 Example 2:

 Input: head = [[1,1],[2,1]]
 Output: [[1,1],[2,1]]

 Example 3:



 Input: head = [[3,null],[3,0],[3,null]]
 Output: [[3,null],[3,0],[3,null]]
 Example 4:

 Input: head = []
 Output: []
 Explanation: Given linked list is empty (null pointer), so return null.

 Constraints:

 -10000 <= Node.val <= 10000
 Node.random is null or pointing to a node in the linked list.
 Number of Nodes will not exceed 1000.
 */
public class CopyListwithRandomPointer {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //Use a hashmap to store original and cloned nodes
    static Map<Node, Node> nodes = new HashMap<>();
    public static void main (String[] args) {
        //head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node (10);
        Node e = new Node(1);
        a.next=b;b.next=c;c.next=d;d.next=e;
        List<Integer> randomList = new ArrayList<>();
        randomList.add(null);randomList.add(0);randomList.add(4);randomList.add(2);randomList.add(0);
        System.out.println("randomList-->"+randomList);
        System.out.println();
       // a.random=null;b.random=a;
        Node node =a; int i=0;
        System.out.print("[");
        while(node!=null && i<randomList.size()) {
            node.random=randomList.get(i) ==null ? null : new Node(randomList.get(i));
            if (node.random==null) System.out.print("["+node.val+","+node.random+"]");
            else System.out.print("["+node.val+","+node.random.val+"]");
            node = node.next;i++;
        }
        System.out.print("]");
        Node deepCopy = copyRandomList(a);
        System.out.println();
        System.out.println("**********Result*******");
        System.out.println();
        System.out.print("[");
        while(deepCopy!=null) {
            if (deepCopy.random==null) System.out.print("["+deepCopy.val+","+deepCopy.random+"]");
            else System.out.print("["+deepCopy.val+","+deepCopy.random.val+"]");
            deepCopy = deepCopy.next;
        }
        System.out.print("]");
    }

    public static Node copyRandomList(Node head) {
        if (head ==null) return null;
        //check if hashmap contains the node
        if (nodes.containsKey(head)) return nodes.get(head);
        else
        //create a new Node and insert
        {
            Node newNode = new Node(head.val);
            nodes.put(head, newNode);
            newNode.next =copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
            return newNode;
        }

    //return head;
    }
}
