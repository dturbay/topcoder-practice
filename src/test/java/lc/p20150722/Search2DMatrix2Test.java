package lc.p20150722;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by denysturbai on 7/22/15.
 */
public class Search2DMatrix2Test {

    @Test
    public void testSearchMatrix() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Search2DMatrix2 search2DMatrix2 = new Search2DMatrix2();
        assertThat(search2DMatrix2.searchMatrix(matrix, 5), Matchers.equalTo(true));
        assertThat(search2DMatrix2.searchMatrix(matrix, 20), Matchers.equalTo(false));
    }

    @Test
    public void testSearchMatrix1() throws Exception {
        int[][] matrix = new int[][]{
                {-1},
                {-1}
        };
        Search2DMatrix2 search2DMatrix2 = new Search2DMatrix2();
        assertThat(search2DMatrix2.searchMatrix(matrix, -1), Matchers.equalTo(true));
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int[][] matrix = new int[][]{
                {3, 3, 8, 13, 13, 18},
                {4, 5, 11, 13, 18, 20},
                {9, 9, 14, 15, 23, 23},
                {13, 18, 22, 22, 25, 27},
                {18, 22, 23, 28, 30, 33},
                {21, 25, 28, 30, 35, 35},
                {24, 25, 33, 36, 37, 40}
        };
        Search2DMatrix2 search2DMatrix2 = new Search2DMatrix2();
        assertThat(search2DMatrix2.searchMatrix(matrix, 21), Matchers.equalTo(true));
    }

}