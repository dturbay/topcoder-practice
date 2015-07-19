package lc.p20150718;

import lc.common.TreeNode;
import lc.common.TreeUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/19/15.
 */
public class InvertBinaryTreeTest {

    @Test
    public void testInvertTree() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        assertThat(TreeUtils.indepthPreorderTraverse(invertBinaryTree.invertTree(root)),
                Matchers.contains(4, 7, 9, 6, 2, 3, 1));
    }
}