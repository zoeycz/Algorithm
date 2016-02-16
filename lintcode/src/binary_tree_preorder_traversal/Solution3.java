package binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution3 {
  /**
   * Solution 3: Non-recursive way
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
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (stack.size() != 0) {
      TreeNode current = stack.pop();
      result.add(current.val);

      // Note: push the right first
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }

    return result;
  }
}
