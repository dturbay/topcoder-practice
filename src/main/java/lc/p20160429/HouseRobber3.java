package lc.p20160429;

import lc.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
   3
  / \
 2  3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobber3 {

  private Map<TreeNode, Integer> cache  = new HashMap<>();

  private int processNode(TreeNode node, boolean available) {
    if (node == null) {
      return 0;
    }
    int max1 = 0;
    if (available) {
      max1 = processNode(node.left, false) + processNode(node.right, false) + node.val;
    }
    if (!cache.containsKey(node.left)) {
      cache.put(node.left, processNode(node.left, true));
    }
    if (!cache.containsKey(node.right)) {
      cache.put(node.right, processNode(node.right, true));
    }
    int max2 =  cache.get(node.left) + cache.get(node.right);
    return Math.max(max1, max2);
  }

  public int rob(TreeNode root) {
    return processNode(root, true);
  }
}
