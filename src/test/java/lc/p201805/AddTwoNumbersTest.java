package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {

  @Test
  public void testSumm() {
    ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode result = new AddTwoNumbers().addTwoNumbers(n1, n2);
    assertThat(807, Matchers.equalTo(result.val + result.next.val * 10 + result.next.next.val * 100));
  }

  @Test
  public void testSumm1() {
    ListNode n1 = new ListNode(5);
    ListNode n2 = new ListNode(5);
    ListNode result = new AddTwoNumbers().addTwoNumbers(n1, n2);
    assertThat(10, Matchers.equalTo(result.val + result.next.val * 10));
  }
}