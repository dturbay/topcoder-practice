package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKSortedListsTest {

  @Test
  public void mergeKLists() {
    ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode list3 = new ListNode(2, new ListNode(6));
    ListNode result = new MergeKSortedLists().mergeKLists(new ListNode[]{list1, list2, list3});
    assertThat(result.toList(), Matchers.contains(1, 1, 2, 3, 4, 4, 5, 6));
  }
}