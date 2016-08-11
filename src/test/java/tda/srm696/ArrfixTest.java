package tda.srm696;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 8/10/16.
 */
public class ArrfixTest {

  @Test
  public void testMindiff0() throws Exception {
    Arrfix arrfix = new Arrfix();
    assertEquals(2, arrfix.mindiff(new int[]{1,1,1}, new int[]{2,2,2}, new int[] {2}));
  }

  @Test
  public void testMindiff1() throws Exception {
    Arrfix arrfix = new Arrfix();
    assertEquals(0, arrfix.mindiff(new int[]{1,1,1}, new int[]{2,2,1}, new int[] {2, 2}));
  }

  @Test
  public void testMindiff2() throws Exception {
    Arrfix arrfix = new Arrfix();
    assertEquals(2, arrfix.mindiff(new int[]{1,2,3}, new int[]{3,2,1}, new int[] {}));
  }

  @Test
  public void testMindiff3() throws Exception {
    Arrfix arrfix = new Arrfix();
    assertEquals(2, arrfix.mindiff(new int[]{2,2,2}, new int[]{2,2,2}, new int[] {1,2,3}));
  }
}