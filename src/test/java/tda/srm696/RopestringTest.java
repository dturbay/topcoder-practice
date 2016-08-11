package tda.srm696;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 8/10/16.
 */
public class RopestringTest {

  @Test
  public void testMakerope() throws Exception {
    Ropestring ropestring = new Ropestring();
    assertEquals("-.-...", ropestring.makerope("..-..-"));
  }

  @Test
  public void testMakerope1() throws Exception {
    Ropestring ropestring = new Ropestring();
    assertEquals("-.-", ropestring.makerope("-.-"));
  }

  @Test
  public void testMakerope2() throws Exception {
    Ropestring ropestring = new Ropestring();
    assertEquals("--.--.---.-..", ropestring.makerope("--..-.---..--"));
  }

  @Test
  public void testMakerope3() throws Exception {
    Ropestring ropestring = new Ropestring();
    assertEquals("--.--.--.-----.---.-....", ropestring.makerope("--..-.---..--..-----.--."));
  }

  @Test
  public void testMakerope4() throws Exception {
    Ropestring ropestring = new Ropestring();
    assertEquals("...", ropestring.makerope("..."));
  }
}
