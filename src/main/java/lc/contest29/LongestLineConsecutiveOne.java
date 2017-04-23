package lc.contest29;

/**
 Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal,
 vertical, diagonal or anti-diagonal.

 Example:
 Input:
 [[0,1,1,0],
  [0,1,1,0],
  [0,0,0,1]]
 Output: 3
 Hint: The number of elements in the given matrix will not exceed 10,000.
 */
public class LongestLineConsecutiveOne {

    public int longestLine(int[][] M) {
        int max = 0;
        for (int i = 0; i < M.length; i++) {
            for (int k = 0; k < M[0].length; k++) {
                if (M[i][k] == 1) {
                    max = Math.max(max, findMax(M, i, k, 0, 1));
                    max = Math.max(max, findMax(M, i, k, 1, 0));
                    max = Math.max(max, findMax(M, i, k, 1, 1));
                    max = Math.max(max, findMax(M, i, k, 1, -1));
                }
            }
        }
        return max;
    }

    private int findMax(int[][] m, int initI, int initK, int dirI, int dirK) {
        boolean checkOnPrev = true;
        if (initI - dirI < 0 || initI - dirI >= m.length) {
            checkOnPrev = false;
        }
        if (initK - dirK < 0 || initK - dirK >= m[0].length) {
            checkOnPrev = false;
        }
        if (checkOnPrev && m[initI - dirI][initK - dirK] == 1) {
            return 0;
        }
        int result = 0;
        for (int i = initI, k = initK; i < m.length && i >= 0 && k < m[0].length && k >= 0; i += dirI, k += dirK) {
            if (m[i][k] == 1) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
