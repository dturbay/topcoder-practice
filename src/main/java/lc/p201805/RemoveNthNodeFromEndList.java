package lc.p201805;


import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * 1->null
 * 1->2->null
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 */

public class RemoveNthNodeFromEndList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode iter = head;
    ListNode distant = head;
    int distance = 1;
    while (iter != null) {
      iter = iter.next;
      if (iter != null) {
        distance++;
        if (distance > n + 1) {
          distance--;
          distant = distant.next;
        }
      }
    }
    if (distance == n) {
      head = head.next;
    } else {
      distant.next = distant.next.next;
    }
    return head;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    ListNode(int x, ListNode next) {
      val = x;
      this.next = next;
    }
  }
}
