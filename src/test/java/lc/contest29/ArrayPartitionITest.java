package lc.contest29;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 4/22/17.
 */
public class ArrayPartitionITest {
    @Test
    public void arrayPairSum() throws Exception {
        assertThat(new ArrayPartitionI().arrayPairSum(new int[] {1,4,3,2}), Matchers.is(4));
    }

}