package lc.p20150718;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicate3Test {

    @Test
    public void testContainsNearbyAlmostDuplicate() throws Exception {
        ContainsDuplicate3 containsDuplicate3 = new ContainsDuplicate3();
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[]{-1, 2147483647}, 1, 2147483647), Matchers.equalTo(false));
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[] {1, 2}, 1, -1), Matchers.equalTo(false));
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[] {-1,-1}, 1, -1), Matchers.equalTo(false));
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[] {0}, 0, 0), Matchers.equalTo(false));
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[] {10, 20, 30, 40, 11, 50}, 4, 5), Matchers.equalTo(true));
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[] {10, 20, 30, 40, 11, 50}, 3, 5), Matchers.equalTo(false));
        assertThat(containsDuplicate3.containsNearbyAlmostDuplicate(
                new int[] {-1,-1}, 1, 0), Matchers.equalTo(true));
    }
}