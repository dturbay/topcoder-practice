package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtoiTest {
  @Test
  public void testAtoi1() {
    assertThat(new Atoi().myAtoi("42"), Matchers.equalTo(42));
  }

  @Test
  public void testAtoi2() {
    assertThat(new Atoi().myAtoi("   -42"), Matchers.equalTo(-42));
  }

  @Test
  public void testAtoi3() {
    assertThat(new Atoi().myAtoi("4193 with words"), Matchers.equalTo(4193));
  }

  @Test
  public void testAtoi4() {
    assertThat(new Atoi().myAtoi("words and 987"), Matchers.equalTo(0));
  }

  @Test
  public void testAtoi5() {
    assertThat(new Atoi().myAtoi("-91283472332"), Matchers.equalTo(-2147483648));
  }

}