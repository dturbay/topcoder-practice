package tda.srm647;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Created by denysturbai on 1/24/15.
 */
@RunWith(Parameterized.class)
public class BuildingTowersTest {

    @Parameterized.Parameters(name = "{index}: makeLine({0}, {1}, {2}, {3})={4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {20, 3, new int[]{4, 7, 13, 15, 18}, new int[]{8, 22, 1, 55, 42}, 22}
        });
    }

    int N;
    int K;
    int[] x;
    int[] t;
    int max;

    public BuildingTowersTest(int n, int k, int[] x, int[] t, int max) {
        N = n;
        K = k;
        this.x = x;
        this.t = t;
        this.max = max;
    }

    @Test
    public void testBuildingTowers() {
//        MatcherAssert.assertThat(new BuildingTowers().maxHeight(N, K, x, t), CoreMatchers.is(max));
    }

}
