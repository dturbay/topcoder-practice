package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
 */
public class LetterCombinationsOfPhoneNumberTest {

  @Test
  public void letterCombinations() {
    assertThat(new HashSet<>(new LetterCombinationsOfPhoneNumber().letterCombinations("23")),
        Matchers.is(new HashSet<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))));
  }

  @Test
  public void letterCombinationsEmptyInput() {
    assertThat(new LetterCombinationsOfPhoneNumber().letterCombinations(""),
        Matchers.is(Collections.emptyList()));

  }
}
