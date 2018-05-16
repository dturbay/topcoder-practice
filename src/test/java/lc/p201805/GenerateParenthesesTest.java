package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

  @Test
  public void generateParenthesis() {
    assertThat(new GenerateParentheses().generateParenthesis(3), Matchers.containsInAnyOrder(
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
    ));
  }

  @Test
  public void generateParenthesisZeroInput () {
    assertThat(new GenerateParentheses().generateParenthesis(0), Matchers.empty());
  }
}