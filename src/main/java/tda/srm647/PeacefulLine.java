package tda.srm647;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by denysturbai on 1/24/15.
 */
public class PeacefulLine {

    public String makeLine(int[] x) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        int maxCount = 0;
        for (int i : x) {
            Integer counter = integerMap.get(i);
            int newCounter;
            if (counter == null) {
                newCounter = 1;
            } else {
                newCounter = counter + 1;
            }
            integerMap.put(i, newCounter);
            if (newCounter > maxCount) {
                maxCount = newCounter;
            }
        }
        if (maxCount > (x.length / 2) + (x.length % 2)) {
            return "impossible";
        } else {
            return "possible";
        }
    }
}
