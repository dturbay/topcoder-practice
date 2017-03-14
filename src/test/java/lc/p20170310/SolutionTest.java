package lc.p20170310;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 3/10/17.
 */
public class SolutionTest {
    @Test
    public void findMedianSortedArrays() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{2}),
                Matchers.is(2.0));
    }

    @Test
    public void findMedianSortedArrays1() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}),
                Matchers.is(2.5));
    }

    @Test
    public void findMedianSortedArrays2() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{2, 4}),
                Matchers.is(2.0));
    }

    @Test
    public void findMedianSortedArrays3() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{1}, new int[]{}),
                Matchers.is(1.0));
    }

    @Test
    public void findMedianSortedArrays4() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{}, new int[]{2, 3}),
                Matchers.is(2.5));
    }

    @Test
    public void findMedianSortedArrays5() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}),
                Matchers.is(1.5));
    }

    @Test
    public void findMedianSortedArrays6() throws Exception {
        assertThat(new Solution().findMedianSortedArrays(new int[]{2, 4, 6, 7, 8}, new int[]{1, 3, 5}),
                Matchers.is(4.5));
    }
}