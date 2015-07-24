package lc.p20150718;

import lc.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Invert a binary tree.
 * 4
 * /    \
 * 2     7
 * / \   / \
 * 1  3  6  9
 * to:
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode current = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                TreeNode tmp = current.left;
                current.left = current.right;
                current.right = tmp;
                stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
            }
        }
        return root;
    }
}
