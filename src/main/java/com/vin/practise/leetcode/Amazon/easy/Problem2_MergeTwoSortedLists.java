package com.vin.practise.leetcode.Amazon.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Definition for singly-linked list
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 */
public class Problem2_MergeTwoSortedLists {
    public static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //recursion starts
        if (l1==null) return l2;
        else if (l2==null) return l1;
        else if (l1.val<l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        //recursion ends;
        //iterative solution starts
        /*ListNode temp = new ListNode(-1);
        ListNode prev = temp;
        while (l1!=null && l2!=null) {
            if (l1.val<=l2.val) {
                prev.next = l1;
                l1= l1.next;
            }
            else {
                prev.next = l2;
                l2 =l2.next;
            }
            prev = prev.next;
        }
        prev = l1!=null ? l1 : l2;
        justPrintListNode(temp.next);
        return temp.next;*/
        //iterative solution ends.
    }
    public static ArrayList<Integer> printListNode(ListNode listNode, ArrayList<Integer> theArrayList) {

        while (listNode!=null) {
            theArrayList.add(listNode.val);
            listNode = listNode.next;
        }
        theArrayList.forEach(x-> System.out.print("-->"+x));
        System.out.println("");
        //System.out.println("The content of arraylist ::"+theArrayList);
        return theArrayList;
    }
    public static void justPrintListNode(ListNode listNode) {

        while (listNode!=null) {
            System.out.print("--->"+listNode.val);
            listNode = listNode.next;
        }
        System.out.println("etf");
        //System.out.println("The content of arraylist ::"+theArrayList);
    }
    public static void main(String [] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1a = new ListNode(2);
        ListNode l1b = new ListNode(4);
        l1.next = l1a;
        l1a.next = l1b;
        l1b.next =null;
        ListNode l2 = new ListNode(1);
        ListNode l2a = new ListNode(3);
        ListNode l2b = new ListNode(4);
        l2.next = l2a;
        l2a.next = l2b;
        l2b.next =null;
        final ListNode listNode = mergeTwoLists(l1, l2);
        justPrintListNode(listNode);
        //printListNode(l1);
        //printListNode(l2);
    }

    /**
     * This iterative solution does following:
     * step 1: creates two temporary nodes. First initialized with value = -1 and Second pointer(prev) to the first one
     * Step 2: idea here is to loop through both the lists until one becomes null
     * Now the second pointer will hold the values gathered from iteration in its next.
     * Since java is storage by reference the first node of prev will be -1 and at last we will return firstNode.next.
     */
}
