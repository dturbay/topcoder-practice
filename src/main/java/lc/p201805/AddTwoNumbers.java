package lc.p201805;


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
