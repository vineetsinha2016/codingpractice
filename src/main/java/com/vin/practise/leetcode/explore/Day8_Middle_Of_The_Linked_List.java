package com.vin.practise.leetcode.explore;

public class Day8_Middle_Of_The_Linked_List {
    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
  public static void main (String[] args) {
        int[] nums = {1,2,3,4,5,6};//{1,2,3,4,5};//
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i=1;i<nums.length;i++) {
            ListNode listNode = new ListNode(nums[i]);
            temp.next = listNode;
            temp = temp.next;
        }
        printListNode(head);
      System.out.println("****** Result ******");
        printListNode(middleNode(head));
  }
  static ListNode middleNode(ListNode head) {
        int count = 0; ListNode temp = head;
        while (temp!=null) {
            count++;
            temp = temp.next;
        }
      //System.out.println("Count -->"+count);
        int newCount = 1;
      count = (count/2) +1;
      //System.out.println("count after division::"+count);
        while (newCount!=count) {
            head = head.next;
            newCount++;
        }
      /*System.out.println("New count-->"+newCount);
      System.out.println("New Head-->"+head.val);*/
        return head;
  }
  static void printListNode(ListNode head) {
      System.out.println();
      while (head!=null) {
          System.out.print(head.val+(head.next!=null ? "-->" :""));
          head=head.next;
      }
  }
}
