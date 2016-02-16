package binary_tree_preorder_traversal;

import java.util.ArrayList;

public class Solution {
  /**
   * Solution 1: Traverse (recursive with helper)
   * 
   * Source: http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
   * 
   * Complexity: Time: O(n), Space: O(n), Extra Space: O(log n)
   * 
   * @param root: The root of binary tree.
   * @return: Preorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    helper(root, result);
    return result;
  }

  // T(n) = T(l) + T(r) + O(1) = 2*T(n/2) + O(1) => T(n) = O(n)
  private void helper(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    helper(root.left, result);
    helper(root.right, result);
  }
}
