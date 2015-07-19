package lc.p20150718;

import lc.p20150718.CountCompleteTreeNodes.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by denysturbai on 7/18/15.
 */
public class CountCompleteTreeNodesTest {

    @Test
    public void testCountNodes() {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        assertThat(countCompleteTreeNodes.countNodes(new TreeNode(1)), Matchers.equalTo(1));
    }

    @Test
    public void testCountNodes1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3));

        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        assertThat(countCompleteTreeNodes.countNodes(root), Matchers.equalTo(4));
    }

    @Test
    public void testCountNodes2() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        assertThat(countCompleteTreeNodes.countNodes(root), Matchers.equalTo(5));
    }
}