package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ThreeSumTest {

  @Test
  public void testThreeSum() {
    int[] array = new int[]{-1, 0, 1, 2, -1, -4};
    assertThat(new ThreeSum().threeSum(array),
        Matchers.containsInAnyOrder(
            Matchers.contains(-1, 0, 1),
            Matchers.contains(-1, -1, 2)));
  }
}