package remove_node_in_binary_search_tree;

import binary_tree_inorder_traversal.TreeNode;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public TreeNode left, right;
 * public TreeNode(int val) { this.val = val; this.left = this.right = null; } }
 */
public class Solution {
  /**
   * @param root: The root of the binary search tree.
   * @param value: Remove the node with given value.
   * @return: The root of the binary search tree after removal.
   */
  public TreeNode removeNode(TreeNode root, int value) {
    if (root == null) {
      return null;
    }
    TreeNode curr = root;
    // Note: prev will be null if match root; handle both case
    TreeNode prev = null;
    while (curr != null && curr.val != value) {
      prev = curr;
      if (value < curr.val) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }

    // Node not found in tree
    if (curr == null) {
      return root;
    }

    // Case 1: node is a leaf, delete
    if (curr.left == null && curr.right == null) {
      if (prev == null) {
        return null;
      }
      if (prev.left == curr) {
        prev.left = null;
      } else {
        prev.right = null;
      }
      // Case 2: node has one child, put the child on
    } else if (curr.left == null) {
      if (prev == null) {
        return curr.right;
      }
      if (prev.left == curr) {
        prev.left = curr.right;
      } else {
        prev.right = curr.right;
      }
    } else if (curr.right == null) {
      if (prev == null) {
        return curr.left;
      }
      if (prev.left == curr) {
        prev.left = curr.left;
      } else {
        prev.right = curr.left;
      }
      // Case 3: node has two children, get leftmost child in right tree
    } else {
      TreeNode leftmost = curr.right;
      while (leftmost.left != null) {
        leftmost = leftmost.left;
      }
      // Note: recursively handle the successor's removal from its original position
      removeNode(curr.right, leftmost.val);
      leftmost.left = curr.left;
      leftmost.right = curr.right;
      if (prev == null) {
        return leftmost;
      }
      if (prev.left == curr) {
        prev.left = leftmost;
      } else {
        prev.right = leftmost;
      }
    }
    return root;
  }
}
