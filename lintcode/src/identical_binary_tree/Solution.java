package identical_binary_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param a, b, the root of binary trees.
   * @return true if they are identical, or false.
   */
  public boolean isIdentical(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    }

    if (a != null && b != null && a.val != b.val) {
      return false;
    }

    if (a == null || b == null) {
      return false;
    }

    boolean left = isIdentical(a.left, b.left);
    boolean right = isIdentical(a.right, b.right);
    return left && right;
  }
}
