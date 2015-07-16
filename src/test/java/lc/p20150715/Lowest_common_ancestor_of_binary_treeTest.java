package lc.p20150715;

import lc.p20150715.Lowest_common_ancestor_of_binary_tree.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/15/15.
 */
public class Lowest_common_ancestor_of_binary_treeTest {

    TreeNode root;
    TreeNode treeNode5;
    TreeNode treeNode1;
    TreeNode treeNode4;

    @Before
    public void setUp() throws Exception {
        root = new TreeNode(3,
                treeNode5 = new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                treeNode4 = new TreeNode(4))),
                treeNode1 = new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
    }

    @Test
    public void testLCA() {
        Lowest_common_ancestor_of_binary_tree lcaFinder =
                new Lowest_common_ancestor_of_binary_tree();
        Assert.assertThat(lcaFinder.lowestCommonAncestor(root, treeNode5, treeNode1),
                Matchers.equalTo(3));
    }
    @Test
    public void testLCA1() {
        Lowest_common_ancestor_of_binary_tree lcaFinder =
                new Lowest_common_ancestor_of_binary_tree();
        Assert.assertThat(lcaFinder.lowestCommonAncestor(root, treeNode5, treeNode4),
                Matchers.equalTo(5));
    }
}