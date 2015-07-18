package lc.p20150717;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        // classic in-depth in order traverse
        int currentIndex = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                currentIndex++;
                if (currentIndex == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
