package lc.p20150809;

import lc.common.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 8/9/15.
 */
public class BinaryTreeRightSideViewTest {

    @Test
    public void testRightSideView() throws Exception {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        null,
                        new TreeNode(4, null, null)));
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        assertThat(binaryTreeRightSideView.rightSideView(treeNode), Matchers.contains(1, 3, 4));
    }
}