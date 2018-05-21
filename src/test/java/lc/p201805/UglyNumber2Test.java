package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumber2Test {

  @Test
  public void nthUglyNumber() {
    assertThat(new UglyNumber2().nthUglyNumber(10), Matchers.is(12));
  }
}