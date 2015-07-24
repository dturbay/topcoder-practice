package lc.p20150718;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ContainsDuplicate2Test {

    @Test
    public void containsNearbyDuplicateTest() {
        ContainsDuplicate2 containsDuplicate2 = new ContainsDuplicate2();
        assertThat(containsDuplicate2.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 2}, 3),
                Matchers.equalTo(true));
        assertThat(containsDuplicate2.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 2}, 2),
                Matchers.equalTo(false));
    }
}