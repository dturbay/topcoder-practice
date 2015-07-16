package tda.srm647;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by denysturbai on 1/24/15.
 */
public class BuildingTowers {

    public long maxHeight(int N, int K, int[] x, int[] t) {
        int maxHeight = 0;
        for (int i = 0; i < x.length; i++) {
            int leftBuildingNmb = i > 0 ? x[i - 1] : 1;
            int maxLeftHeight = i > 0 ? t[i - 1] : 0;
            int rightBuildingNmb = x[i];
            int maxRightHeight = t[i];
            int maxDiapHeight = Math.max(maxLeftHeight, maxRightHeight);
            int distance = rightBuildingNmb - leftBuildingNmb - 1;
            int heightDiff = Math.abs(maxLeftHeight - maxRightHeight);
            distance -= heightDiff / K;
            int incr = 0;
            if (heightDiff % K != 0 && distance > 0) {
                incr = -K;
            }
            int currentMax = 0;
            if (distance % 2 == 0) {
                currentMax = maxDiapHeight + ((distance / 2) * K);
            } else {
                currentMax = maxDiapHeight + ((distance / 2) + 1) * K + incr;
            }
            maxHeight = Collections.max(Arrays.asList(
                    maxHeight, currentMax));
        }
        return maxHeight;
    }

}
