package lc.contest28;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 4/15/17.
 */
public class Problem1Test {
    @Test
    public void checkRecord() throws Exception {
        assertThat(new Problem1().checkRecord("PPALLP"), Matchers.is(true));
    }

    @Test
    public void checkRecord1() throws Exception {
        assertThat(new Problem1().checkRecord("PPALLL"), Matchers.is(false));
    }
}