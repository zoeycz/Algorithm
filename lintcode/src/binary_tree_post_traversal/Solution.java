package binary_tree_post_traversal;

import java.util.ArrayList;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: Postorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    helper(root, result);
    return result;
  }

  private void helper(TreeNode node, ArrayList<Integer> res) {
    if (node == null) {
      return;
    }
    helper(node.left, res);
    helper(node.right, res);
    res.add(node.val);
  }
}
