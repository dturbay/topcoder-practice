package lc.contest28;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 4/15/17.
 */
public class Problem2Test {
    @Test
    public void optimalDivision() throws Exception {
        assertThat(new Problem2().optimalDivision(new int[]{1000, 100, 10, 2}),
                Matchers.is("1000/(100/10/2)"));
    }

}