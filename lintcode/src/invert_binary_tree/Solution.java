package invert_binary_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: a TreeNode, the root of the binary tree
   * @return: nothing
   */
  public void invertBinaryTree(TreeNode root) {
    helper(root);
  }

  private void helper(TreeNode node) {
    if (node == null) {
      return;
    }
    helper(node.left);
    helper(node.right);
    TreeNode tmp = node.left;
    node.left = node.right;
    node.right = tmp;
  }
}
