package tda.srm647;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by denysturbai on 1/24/15.
 */
@RunWith(Parameterized.class)
public class PeacefulLineTest {

    public static final String POSSIBLE = "possible";
    public static final String IMPOSSIBLE = "impossible";

    @Parameterized.Parameters(name = "{index}: makeLine({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 2, 2, 3, 3, 4, 4}, POSSIBLE},
                {new int[]{3, 7, 7, 7, 3, 7, 7, 7, 3}, IMPOSSIBLE},
                {new int[]{3, 3, 3, 3, 13, 13, 13, 13, 3}, POSSIBLE}
        });
    }

    private int[] input;
    private String expected;

    public PeacefulLineTest(int[] input, String expected) {
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void testExpectedValues1() {
        MatcherAssert.assertThat(new PeacefulLine().makeLine(input), CoreMatchers.is(expected));
    }
}
