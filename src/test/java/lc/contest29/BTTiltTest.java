package lc.contest29;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by denysturbai on 4/22/17.
 */
public class BTTiltTest {

    @Test
    public void findTilt() throws Exception {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(5);
        node.right = new TreeNode(50);
        assertThat(new BTTilt().findTilt(node), Matchers.is(45));
    }

}