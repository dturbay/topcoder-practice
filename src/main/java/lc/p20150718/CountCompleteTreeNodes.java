package lc.p20150718;

import lc.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a complete binary tree, count the number of nodes.
 Definition of a complete binary tree from Wikipedia:
 http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees
 In a complete binary tree every level, except possibly the last, is completely filled, and all
 nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive
 at the last level h.
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        int maxCount = (1 << (height + 1)) - 1;
        if (height == rightHeight) {
            return maxCount;
        }
        Deque<Integer> stack = new LinkedList<>();
        TreeNode current = root;
        int currentHeight = 1;
        while (true) {
            int leftRightHeight;
            if (current.left != null) {
                leftRightHeight = getRightHeight(current.left) + currentHeight;
            } else {
                leftRightHeight = currentHeight - 1;
            }
            if (leftRightHeight != height) {
                current = current.left;
                stack.push(0);
            } else {
                current = current.right;
                stack.push(1);
            }
            if (current == null) {
                break;
            }
            currentHeight++;
        }
        int power2 = 1;
        int nodeNumber = 0;
        while (!stack.isEmpty()) {
            nodeNumber += stack.pop() * power2;
            power2 *= 2;
        }

        int maxLastRowSize = 1 << height;
        return maxCount - (maxLastRowSize - nodeNumber);
    }

    private int getLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height - 1;
    }

    private int getRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        while (root != null) {
            height++;
            root = root.right;
        }
        return height - 1;
    }
}
