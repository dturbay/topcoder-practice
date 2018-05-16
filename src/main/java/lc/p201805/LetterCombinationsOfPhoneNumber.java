package lc.p201805;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return Collections.emptyList();
    }
    Map<Character, char[]> numberByLetters = new HashMap<>();
    numberByLetters.put('2', new char[] {'a', 'b', 'c'});
    numberByLetters.put('3', new char[] {'d', 'e', 'f'});
    numberByLetters.put('4', new char[] {'g', 'h', 'i'});
    numberByLetters.put('5', new char[] {'j', 'k', 'l'});
    numberByLetters.put('6', new char[] {'m', 'n', 'o'});
    numberByLetters.put('7', new char[] {'p', 'q', 'r', 's'});
    numberByLetters.put('8', new char[] {'t', 'u', 'v'});
    numberByLetters.put('9', new char[] {'w', 'x', 'y', 'z'});

    int[] indexes = new int[digits.length()];
    char[] number = digits.toCharArray();
    List<String> result = new ArrayList<>();
    boolean finished = false;
    while ( !finished ) {
      String word = "";
      for (int i = 0 ; i < number.length ; i++) {
        char[] charsForNumber = numberByLetters.get(number[i]);
        word += charsForNumber[indexes[i]];
      }
      result.add(word);

      int i = 0;
      boolean carryOver = true;
      while (i < indexes.length && carryOver) {
        if (indexes[i] == numberByLetters.get(number[i]).length - 1) {
          indexes[i] = 0;
          carryOver = true;
        } else {
          indexes[i]++;
          carryOver = false;
        }
        i++;
      }
      if (carryOver) {
        finished = true;
      }
    }
    return result;
  }
}
