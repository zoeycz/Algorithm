package balance_binary_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: True if this Binary tree is Balanced, or false.
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int l = height(root.left);
    int r = height(root.right);
    // Note: How to decide balance
    if ((l == r || l + 1 == r || l == r + 1) && isBalanced(root.left) && isBalanced(root.right)) {
      return true;
    }
    return false;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = height(root.left);
    int r = height(root.right);
    int h = Math.max(l, r) + 1;
    return h;
  }
}
