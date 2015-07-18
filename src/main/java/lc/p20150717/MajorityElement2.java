package lc.p20150717;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElement2 {

    public static final int CACHE_CAPACITY = 3;

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> occurrence = new HashMap<>(CACHE_CAPACITY);
        for (int num : nums) {
            if (occurrence.size() < CACHE_CAPACITY) {
                Integer value = occurrence.get(num);
                if (value == null) {
                    value = 0;
                }
                occurrence.put(num, value + 1);
            } else if (occurrence.containsKey(num)) {
                occurrence.put(num, occurrence.get(num) + 1);
            } else {
                Map.Entry<Integer, Integer> min = getMinOccurrenceEntry(occurrence);
                if (min.getValue() == 0) {
                    occurrence.remove(min.getKey());
                    occurrence.put(num, 1);
                } else {
                    Map<Integer, Integer> updatedCache = new HashMap<>(CACHE_CAPACITY);
                    for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
                        int value = entry.getValue() - 1;
                        updatedCache.put(entry.getKey(), value);
                    }
                    occurrence = updatedCache;
                    min = getMinOccurrenceEntry(occurrence);
                    if (min.getValue() == 0) {
                        occurrence.remove(min.getKey());
                        occurrence.put(num, 1);
                    }
                }
            }
        }
        return checkResults(occurrence, nums);
    }

    private Map.Entry<Integer, Integer> getMinOccurrenceEntry(Map<Integer, Integer> occurrence) {
        Map.Entry<Integer, Integer> min = null;
        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            if (min == null) {
                min = entry;
            } else {
                if (entry.getValue() < min.getValue()) {
                    min = entry;
                }
            }
        }
        return min;
    }

    private List<Integer> checkResults(Map<Integer, Integer> cache, int[] nums) {
        Map<Integer, Integer> occurrence = new HashMap<>(CACHE_CAPACITY);
        for (Integer integer : cache.keySet()) {
            occurrence.put(integer, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (occurrence.containsKey(num)) {
                occurrence.put(num, occurrence.get(num) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
