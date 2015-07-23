package lc.p20150722;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/22/15.
 */
public class Search2DMatrix2Test {

    @Test
    public void testSearchMatrix() throws Exception {
        int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Search2DMatrix2 search2DMatrix2 = new Search2DMatrix2();
        assertThat(search2DMatrix2.searchMatrix(matrix, 5), Matchers.equalTo(true));
        assertThat(search2DMatrix2.searchMatrix(matrix, 20), Matchers.equalTo(false));
    }
}