package validate_binary_search_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  private int lastValue = Integer.MIN_VALUE;
  private boolean firstNode = true;

  /**
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST(TreeNode root) {
    // Note: has to be inorder traversal as leftmost & rightmost may equal to min & max; cannot set
    // boundary
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }
    if (!firstNode && root.val <= lastValue) {
      return false;
    }
    firstNode = false;
    lastValue = root.val;
    if (!isValidBST(root.right)) {
      return false;
    }
    return true;
  }
}
