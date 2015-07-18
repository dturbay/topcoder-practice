package lc.p20150717;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static lc.p20150717.KthSmallestElementinaBST.*;
import static org.junit.Assert.*;

/**
 * Created by denysturbai on 7/17/15.
 */
public class KthSmallestElementinaBSTTest {

    private TreeNode root;

    @Before
    public void setup() {
        root = new TreeNode(20,
                new TreeNode(10,
                        new TreeNode(5),
                        new TreeNode((15))),
                new TreeNode(30,
                        new TreeNode(25),
                        new TreeNode(35)));
    }


    @Test
    public void fifthElement() {
        KthSmallestElementinaBST kthSmallestElementinaBST = new KthSmallestElementinaBST();
        assertThat(kthSmallestElementinaBST.kthSmallest(root, 6), Matchers.equalTo(30));
    }
}