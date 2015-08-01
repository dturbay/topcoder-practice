package lc.p20150729;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/29/15.
 */
public class CombinationSum3Test {

    @Test
    public void testCombinationSum3() throws Exception {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        assertThat(combinationSum3.combinationSum3(3, 7),
                Matchers.containsInAnyOrder(Arrays.asList(1, 2, 4)));
    }

    @Test
    public void testCombinationSum31() throws Exception {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        assertThat(combinationSum3.combinationSum3(3, 9),
                Matchers.containsInAnyOrder(Arrays.asList(1, 2, 6), Arrays.asList(1,3,5),
                        Arrays.asList(2,3,4)));
    }
}
