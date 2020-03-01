package com.vin.practise.leetcode.Amazon.oa;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 */
public class MergeTwoSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main (String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        printout(l1);printout(l2);
        ListNode l = mergeTwoLists(l1,l2);
        System.out.println("******Result ********* ");
        printout(l);
    }
    static void printout(ListNode l) {
        System.out.println();
        while(l!=null) {
            System.out.print(l.val+"-->");
            l=l.next;
        }
        System.out.println();
    }
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        else if (l2==null) return l1;
        else if (l1.val<l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);//assignment is important
            return l1;
        }
        else {
             l2.next = mergeTwoLists(l1,l2.next);//assignment is important
             return l2;
        }
    }
}
