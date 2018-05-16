package lc.p201805;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 For example, given n = 3, a solution set is:
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {

  private void getAllVariants(int openCount, int closedCount, int balance, List<String> result,
                                    Deque<Character> currentStack) {
    if (openCount == 0 && closedCount == 0) {
      String solution = "";
      Iterator<Character> it = currentStack.descendingIterator();
      while (it.hasNext()) {
        solution += it.next();
      }
      result.add(solution);
    } else {
      // can add open parenthesis
      if (openCount > 0) {
        currentStack.push('(');
        getAllVariants(openCount - 1, closedCount, balance + 1, result, currentStack);
        currentStack.pop();
      }
      // can add closed parenthesis
      if (balance > 0) {
        currentStack.push(')');
        getAllVariants(openCount, closedCount - 1, balance - 1, result, currentStack);
        currentStack.pop();
      }
    }
  }

  public List<String> generateParenthesis(int n) {
    int openCount = n;
    int closedCount = n;
    int balance = 0;
    List<String> result = new ArrayList<>();
    Deque<Character> currentStack = new ArrayDeque<>();

    if (n == 0) {
      return result;
    }
    getAllVariants(openCount, closedCount, balance, result, currentStack);

    return result;
  }
}
