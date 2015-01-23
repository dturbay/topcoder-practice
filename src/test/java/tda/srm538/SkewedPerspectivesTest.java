package tda.srm538;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by denysturbai on 1/21/15.
 */

public class SkewedPerspectivesTest {

    @Test
    public void expectValue() {
        assertThat(new SkewedPerspectives().areTheyPossible(new int[]{0, 1, 0}, 3, 2, new String[]{"b", "bb", "bbb", "bbbb", "bbbbb", "bbbbbb",
                "1", "1b", "1bb", "1bbb", "1bbbb", "1bbbbb", "1bbbbbb",
                "b1", "b1b", "b1bb", "b1bbb", "b1bbbb", "b1bbbbb",
                "bb1", "bb1b", "bb1bb", "bb1bbb", "bb1bbbb",
                "bbb1", "bbb1b", "bbb1bb", "bbb1bbb",
                "bbbb1", "bbbb1b", "bbbb1bb",
                "bbbbb1", "bbbbb1b",
                "bbbbbb1"}),
                is(new String[]{"invalid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "valid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "valid",
                "valid",
                "valid",
                "invalid",
                "valid",
                "invalid",
                "invalid",
                "invalid",
                "invalid",
                "valid",
                "invalid",
                "valid",
                "invalid",
                "invalid",
                "valid"}));
    }

}
