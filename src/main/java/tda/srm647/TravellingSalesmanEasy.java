package tda.srm647;

import java.util.*;

/**
 * Created by denysturbai on 1/24/15.
 */
public class TravellingSalesmanEasy {

    public int getMaxProfit(int M, int[] profit, int[] city, int[] visit) {
        Map<Integer, List<Integer>> profitsByCities = new HashMap<>();
        for (int i = 0 ; i < city.length ; i++) {
            int c = city[i];
            if (!profitsByCities.containsKey(c)) {
                profitsByCities.put(c, new ArrayList<>());
            }
            List<Integer> profits = profitsByCities.get(c);
            profits.add(profit[i]);
        }
        for (List<Integer> list : profitsByCities.values()) {
            Collections.sort(list);
        }
        int totalProfit = 0;
        for (int i : visit) {
            List<Integer> profits = profitsByCities.get(i);
            if (profits != null && !profits.isEmpty()) {
                totalProfit += profits.remove(profits.size() - 1);
            }
        }
        return totalProfit;
    }

}
