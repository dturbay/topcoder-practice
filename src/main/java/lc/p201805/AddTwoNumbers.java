package lc.p201805;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */

class ListNode {
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


public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode last = null;
    int carryOver = 0;
    while (l1 != null || l2 != null || carryOver > 0) {
      int n1 = l1 != null ? l1.val : 0;
      int n2 = l2 != null ? l2.val : 0;
      int digit = n1 + n2 + carryOver;
      if (digit > 9) {
        carryOver = 1;
        digit = digit % 10;
      } else {
        carryOver = 0;
      }
      if (result == null) {
        result = last = new ListNode(digit);
      } else {
        last.next = new ListNode(digit);
        last = last.next;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return result;
  }
}
