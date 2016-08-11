package tda.srm696;

import org.junit.Test;

import static org.junit.Assert.*;

public class Clicountingd2Test {

  @Test
  public void testCount0() throws Exception {
    assertEquals(2, new Clicountingd2().count(new String[]{"01","10"}));
  }

  @Test
  public void testCount1() throws Exception {
    assertEquals(3, new Clicountingd2().count(new String[]{"0?","?0"}));
  }

  @Test
  public void testCount2() throws Exception {
    assertEquals(3, new Clicountingd2().count(new String[]{"011","101","110"}));
  }

  @Test
  public void testCount3() throws Exception {
    assertEquals(5, new Clicountingd2().count(new String[]{"0?1","?01","110"}));
  }

  @Test
  public void testCount4() throws Exception {
    assertEquals(151, new Clicountingd2().count(new String[]{"0???","?0??","??0?","???0"}));
  }

}