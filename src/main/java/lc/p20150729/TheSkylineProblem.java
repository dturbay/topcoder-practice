package lc.p20150729;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return Collections.emptyList();
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            treeSet.add(building[0]);
            treeSet.add(building[1]);
        }
        List<int[]> updatedBuildings = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            Set<Integer> internal = treeSet.subSet(building[0], false, building[1], false);
            int prevBorder = building[0];
            for (Integer border : internal) {
                updatedBuildings.add(new int[]{prevBorder, border, building[2]});
                prevBorder = border;
            }
            updatedBuildings.add(new int[] {prevBorder, building[1], building[2]});
        }
        updatedBuildings.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                if (o1[0] == o2[0]) return 0;
                return 1;
            }
        });
        List<int[]> noDuplicatesX = new ArrayList<>();
        int[] prev = updatedBuildings.get(0);
        int[] current = null;
        for (int i = 1; i < updatedBuildings.size(); i++) {
            current = updatedBuildings.get(i);
            if (current[0] != prev[0]) {
                noDuplicatesX.add(prev);
                prev = current;
            } else {
                if (prev[2] < current[2]) {
                    prev = current;
                }
            }
        }
        noDuplicatesX.add(prev);

        List<int[]> noDuplicatesH = new ArrayList<>();
        prev = noDuplicatesX.get(0);
        current = null;
        for (int i = 1; i < noDuplicatesX.size(); i++) {
            current = noDuplicatesX.get(i);
            if (current[0] == prev[1] && prev[2] == current[2]) {
                prev = new int[] {prev[0], current[1], current[2]};
            } else {
                noDuplicatesH.add(prev);
                prev = current;
            }
        }
        noDuplicatesH.add(prev);

        List<int[]> result = new ArrayList<>();
        prev = null;
        int[] bar = null;
        for (int i = 0; i < noDuplicatesH.size(); i++) {
            bar = noDuplicatesH.get(i);
            if (prev != null && prev[1] != bar[0]) {
                result.add(new int[]{prev[1], 0});
            }
            result.add(new int[]{bar[0], bar[2]});
            prev = bar;
        }
        result.add(new int[]{bar[1], 0});
        return result;
    }
}
