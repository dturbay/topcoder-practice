package lc.p201805;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagConversionTest {

  @Test
  public void testConversion() {
    assertThat(new ZigZagConversion().convert("PAYPALISHIRING", 3),
        Matchers.equalTo("PAHNAPLSIIGYIR"));
  }

  @Test
  public void testConversion1() {
    assertThat(new ZigZagConversion().convert("PAYPALISHIRING", 4),
        Matchers.equalTo("PINALSIGYAHRPI"));
  }

  @Test
  public void testConversion2() {
    assertThat(new ZigZagConversion().convert("AB", 1),
        Matchers.equalTo("AB"));
  }
}