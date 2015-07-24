package lc.p20150722;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.
 Given target = 20, return false.
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        Queue<SearchArea> searchAreas = new LinkedList<>();
        searchAreas.add(new SearchArea(0, 0, matrix.length - 1, matrix[0].length - 1));
        while (!searchAreas.isEmpty()) {
            SearchArea area = searchAreas.remove();
            int topLeftX = area.topLeftX;
            int topLeftY = area.topLeftY;
            int botRightX = area.botRightX;
            int botRightY = area.botRightY;
            if (matrix[topLeftX][topLeftY] > target
                    || matrix[botRightX][botRightY] < target) {
                continue;
            }
            if (topLeftX == botRightX) {
                if (Arrays.binarySearch(matrix[topLeftX], topLeftY, botRightY + 1, target) >= 0) {
                    return true;
                } else {
                    continue;
                }
            }
            if (topLeftY == botRightY) {
                int[] column = createArray(matrix, topLeftY, topLeftX, botRightX + 1);
                if (Arrays.binarySearch(column, target) >= 0) {
                    return true;
                } else {
                    continue;
                }
            }
            while (matrix[botRightX][botRightY] >= target
                    && topLeftX < botRightX
                    && topLeftY < botRightY) {
                botRightX--;
                botRightY--;
            }
            if (matrix[botRightX][botRightY] == target) {
                return true;
            }
            if (matrix[botRightX][botRightY] > target) {
                if (botRightY == area.topLeftY) {
                    searchAreas.add(new SearchArea(topLeftX, topLeftY, botRightX - 1, area.botRightY));
                } else {
                    searchAreas.add(new SearchArea(topLeftX, topLeftY, area.botRightX, botRightY - 1));
                }
            } else {
                searchAreas.add(new SearchArea(botRightX + 1, area.topLeftY, area.botRightX, area.botRightY));
                searchAreas.add(new SearchArea(area.topLeftX, botRightY + 1, botRightX, area.botRightY));
            }
        }
        return false;
    }

    private int[] createArray(int[][] matrix, int colInd, int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < to - from ; i++) {
            result[i] = matrix[from + i][colInd];
        }
        return result;
    }

    static class SearchArea {
        int topLeftX;
        int topLeftY;
        int botRightX;
        int botRightY;
        public SearchArea(int topLeftX, int topLeftY, int botRightX, int botRightY) {
            this.topLeftX = topLeftX;
            this.topLeftY = topLeftY;
            this.botRightX = botRightX;
            this.botRightY = botRightY;
        }
    }
}
