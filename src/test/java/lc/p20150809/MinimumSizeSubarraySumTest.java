package lc.p20150809;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 8/11/15.
 */
public class MinimumSizeSubarraySumTest {

    @Test
    public void testMinSubArrayLen() throws Exception {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        assertThat(minimumSizeSubarraySum.minSubArrayLen(7, new int[] {2,3,1,2,4,3}),
                Matchers.equalTo(2));
    }
}