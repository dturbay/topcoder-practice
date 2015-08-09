package lc.p20150729;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 8/1/15.
 */
public class TheSkylineProblemTest {

    @Test
    public void testGetSkyline() throws Exception {
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        int[][] buildings = new int[][] {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}};
        assertThat(theSkylineProblem.getSkyline(buildings), Matchers.contains(
                new int[]{2, 10}, new int[]{3, 15}, new int[]{7, 12}, new int[]{12, 0},
                new int[]{15, 10}, new int[]{20, 8}, new int[]{24, 0}));
    }

    @Test
    public void testGetSkyline1() throws Exception {
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        int[][] buildings = new int[][]{
                {0, 1, 3}
        };
        assertThat(theSkylineProblem.getSkyline(buildings), Matchers.contains(
                new int[]{0, 3}, new int[]{1, 0}));
    }
}