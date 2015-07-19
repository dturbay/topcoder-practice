package lc.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public abstract class TreeUtils {

    public static List<Integer> indepthPreorderTraverse(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> rightNodes = new LinkedList<>();
        while (node != null || !rightNodes.isEmpty()) {
            if (node != null) {
                result.add(node.val);
                if (node.right != null) {
                    rightNodes.push(node.right);
                }
                node = node.left;
            } else {
                node = rightNodes.pop();
            }
        }
        return result;
    }

}
