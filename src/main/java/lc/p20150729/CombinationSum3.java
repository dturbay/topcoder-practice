package lc.p20150729;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 Ensure that numbers within the set are sorted in ascending order.
 Example 1:
 Input: k = 3, n = 7
 Output:
 [[1,2,4]]
 Example 2:
 Input: k = 3, n = 9
 Output:
 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Sol>[] results = new List[n];
        // initial solutions
        for (int i = 0 ; i < Math.min(9, n); i++) {
            results[i] = Collections.singletonList(new Sol(Collections.singletonList(i + 1)));
        }
        for (int m = 0; m < k - 1; m++) {
            List<Sol>[] newResult = new List[n];
            for (int j = 1; j < 10; j++) {
                for (int i = 0; i < n; i++) {
                    if (i + j < n) {
                        List<Sol> numbers = results[i];
                        if (numbers != null) {
                            for (Sol sol : numbers) {
                                if (sol.numbers.get(sol.numbers.size() - 1) < j) {
                                    List<Integer> newComb = new ArrayList<>(sol.numbers);
                                    newComb.add(j);
                                    if (newResult[i + j] == null) {
                                        newResult[i + j] = new ArrayList<>();
                                    }
                                    newResult[i + j].add(new Sol(newComb));
                                }
                            }
                        }
                    }
                }
            }
            results = newResult;
        }
        List<List<Integer>> foundList = new ArrayList<>();
        if (results[n - 1] != null) {
            for (Sol sol: results[n - 1]) {
                foundList.add(sol.numbers);
            }
        }
        return foundList;
    }

    static class Sol {
        List<Integer> numbers = new ArrayList<>();

        public Sol(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }
}
