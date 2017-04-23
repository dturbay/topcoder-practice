package lc.contest29;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 4/22/17.
 */
public class LongestLineConsecutiveOneTest {
    @Test
    public void longestLine() throws Exception {
        assertThat(new LongestLineConsecutiveOne().longestLine(
                new int[][]{{0,1,1,0},
                            {0,1,1,0},
                            {0,0,0,1}}), Matchers.is(3));
    }

    @Test
    public void longestLine1() throws Exception {
        assertThat(new LongestLineConsecutiveOne().longestLine(
                new int[][]
                        {
                                {1,1,0,0,1,0,0,1,1,0},
                                {1,0,0,1,0,1,1,1,1,1},
                                {1,1,1,0,0,1,1,1,1,0},
                                {0,1,1,1,0,1,1,1,1,1},
                                {0,0,1,1,1,1,1,1,1,0},
                                {1,1,1,1,1,1,0,1,1,1},
                                {0,1,1,1,1,1,1,0,0,1},
                                {1,1,1,1,1,0,0,1,1,1},
                                {0,1,0,1,1,0,1,1,1,1},
                                {1,1,1,0,1,0,1,1,1,1}}),
        Matchers.is(9));
    }
}