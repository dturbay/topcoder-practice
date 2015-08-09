package lc.p20150809;

import lc.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of
 * the nodes you can see ordered from top to bottom.
 For example:
 Given the following binary tree,
    1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode treeNode = root;
        Deque<TreeNodeWrapper> stack = new LinkedList<>();
        int maxProcessedLevel = 0;
        int currentProcessedLevel = 1;
        while (treeNode != null || !stack.isEmpty())  {
            if (treeNode != null) {
                if (currentProcessedLevel > maxProcessedLevel) {
                    result.add(treeNode.val);
                    maxProcessedLevel = currentProcessedLevel;
                }
                stack.push(new TreeNodeWrapper(treeNode.left, currentProcessedLevel + 1));
                treeNode = treeNode.right;
                currentProcessedLevel++;
            } else {
                TreeNodeWrapper treeNodeWrapper = stack.pop();
                treeNode = treeNodeWrapper.treeNode;
                currentProcessedLevel = treeNodeWrapper.level;
            }
        }
        return result;
    }

    static class TreeNodeWrapper {
        TreeNode treeNode;
        int level;

        public TreeNodeWrapper(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
}
