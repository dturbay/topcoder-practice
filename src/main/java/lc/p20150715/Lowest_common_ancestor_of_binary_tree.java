package lc.p20150715;


import lc.common.TreeNode;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes v and w as the lowest node in T that has both v and w as
 * descendants (where we allow a node to be a descendant of itself).”
 */
public class Lowest_common_ancestor_of_binary_tree {

    private static Deque<TreeNode> getPathFromRoot(TreeNode node, TreeNode p) {
        if (node == p) {
            return new LinkedList<>(Collections.singleton(p));
        } else if (node == null) {
            return new LinkedList<>();
        } else {
            TreeNode currentNode = node;
            Deque<TreeNode> currentPath = new LinkedList<>();
            Map<TreeNode, Direction> directionMap = new HashMap<>();
            currentPath.push(currentNode);
            while (currentNode != null) {
                if (!directionMap.containsKey(currentNode)) {
                    directionMap.put(currentNode, Direction.LEFT);
                    if (currentNode.left != null) {
                        currentPath.push(currentNode.left);
                        currentNode = currentNode.left;
                    }
                } else if (directionMap.get(currentNode) == Direction.LEFT) {
                    directionMap.put(currentNode, Direction.RIGHT);
                    if (currentNode.right != null) {
                        currentPath.push(currentNode.right);
                        currentNode = currentNode.right;
                    }
                } else {
                    currentNode = currentPath.pop();
                    currentNode = currentPath.getFirst();
                }
                if (currentNode == p) {
                    return currentPath;
                }
            }
            return new LinkedList<>();
        }
    }

    enum Direction {
        LEFT, RIGHT;
    }

    public void debugTreePrint(TreeNode node) {
        Deque<TreeNode> rightNodes = new LinkedList<>();
        while (node != null || !rightNodes.isEmpty()) {
            if (node != null) {
                System.out.println(node.val);
                if (node.right != null) {
                    rightNodes.push(node.right);
                }
                node = node.left;
            } else {
                node = rightNodes.pop();
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> firstPathFromRoot = getPathFromRoot(root, p);
        Deque<TreeNode> secondPathFromRoot = getPathFromRoot(root, q);
        if (firstPathFromRoot.isEmpty() || secondPathFromRoot.isEmpty()) {
            return null;
        } else {
            TreeNode result = null;
            while (!(firstPathFromRoot.isEmpty() || secondPathFromRoot.isEmpty())) {
                TreeNode treeNode = firstPathFromRoot.removeLast();
                if (treeNode != secondPathFromRoot.removeLast()) {
                    break;
                }
                result = treeNode;
            }
            return result;
        }
    }
}
