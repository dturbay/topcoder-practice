package lc.p20150722;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by denysturbai on 7/23/15.
 */
public class KthLargestElementInArrayTest {

    @Test
    public void testFindKthLargest() throws Exception {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        assertThat(kthLargestElementInArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2),
                Matchers.equalTo(5));
    }
}