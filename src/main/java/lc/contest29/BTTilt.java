package lc.contest29;

/**
 * Created by denysturbai on 4/22/17.
 */
public class BTTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(treeSum(root.left) - treeSum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    private int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }
}


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
