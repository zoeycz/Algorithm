package binary_tree_inorder_traversal;

import java.util.ArrayList;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: Inorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    helper(result, root);
    return result;
  }

  private void helper(ArrayList<Integer> result, TreeNode root) {
    if (root == null) {
      return;
    }
    helper(result, root.left);
    result.add(root.val);
    helper(result, root.right);
  }
}
