package max_depth_of_a_binary_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: An integer.
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = maxDepth(root.left);
    int r = maxDepth(root.right);
    int h = 1 + Math.max(l, r);
    return h;
  }
}
