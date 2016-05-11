package lc.p20160429;

import lc.common.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobber3Test {

  @Test
  public void robTest() {
    TreeNode root = new TreeNode(3,
        new TreeNode(2,
            null,
            new TreeNode(3)),
        new TreeNode(3,
            null,
            new TreeNode(1)));

    assertThat(new HouseRobber3().rob(root), Matchers.is(7));
  }
}
