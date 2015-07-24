package lc.p20150717;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class MajorityElement2Test {

    @Test
    public void findMajorityElem1() {
        MajorityElement2 majorityElement2 = new MajorityElement2();
        assertThat(majorityElement2.majorityElement(new int[]{1, 2, 3, 1, 2, 5, 2, 1}),
                Matchers.containsInAnyOrder(1, 2));
    }

    @Test
    public void findMajorityElem2() {
        MajorityElement2 majorityElement2 = new MajorityElement2();
        assertThat(majorityElement2.majorityElement(new int[]{1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                Matchers.containsInAnyOrder(1));
    }
}