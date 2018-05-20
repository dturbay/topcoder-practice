package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;
import lc.p201805.RemoveNthNodeFromEndList.ListNode;

import static org.junit.Assert.*;

public class RemoveNthNodeFromEndListTest {

  @Test
  public void removeNthFromEnd() {
    ListNode list = new ListNode(1, new ListNode(2,
        new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode result = new RemoveNthNodeFromEndList().removeNthFromEnd(list, 2);
    assertThat(result, Matchers.is(list));
    assertThat(result.val, Matchers.is(1));
    assertThat(result.next.val, Matchers.is(2));
    assertThat(result.next.next.val, Matchers.is(3));
    assertThat(result.next.next.next.val, Matchers.is(5));
  }
}