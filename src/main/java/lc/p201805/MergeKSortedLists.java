package lc.p201805;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 Example:
 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    List<ListNode> linkedLists = new LinkedList();
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        linkedLists.add(lists[i]);
      }
    }
    ListNode head = null;
    ListNode current = null;
    while ( !linkedLists.isEmpty() ) {
      Integer min = getMin(linkedLists);
      ListNode node = new ListNode(min);
      if (current != null) {
        current.next = node;
        current = node;
      } else {
        head = current = node;
      }
    }
    return head;
  }

  Integer getMin(List<ListNode> linkedLists) {
    ListNode min = linkedLists.get(0);
    Iterator<ListNode> it = linkedLists.iterator();
    while (it.hasNext()) {
      ListNode node = it.next();
      if (node.val < min.val) {
        min = node;
      }
    }
    linkedLists.remove(min);
    Integer result = min.val;
    min = min.next;
    if (min != null) {
      linkedLists.add(min);
    }
    return result;
  }
}
