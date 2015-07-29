package lc.p20150728;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/28/15.
 */
public class DifferentWaysToAddParenthesesTest {

    @Test
    public void testDiffWaysToCompute() throws Exception {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        assertThat(differentWaysToAddParentheses.diffWaysToCompute("2-1-1"),
                Matchers.containsInAnyOrder(0, 2));
    }

    @Test
    public void testDiffWaysToCompute1() throws Exception {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        assertThat(differentWaysToAddParentheses.diffWaysToCompute("2*3-4*5"),
                Matchers.containsInAnyOrder(-34, -14, -10, -10, 10));
    }
}