package binary_tree_post_traversal;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree_inorder_traversal.TreeNode;

public class Solution2 {
  /**
   * @param root: The root of binary tree.
   * @return: Postorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    TreeNode cur = root;

    stack.push(root);
    while (stack.size() > 0) {
      cur = stack.peek();
      // Traverse down the tree; handle child children first
      if (prev == null || cur == prev.left || cur == prev.right) {
        // Note: if left exist, push the left only; right will be handled when left is handled
        if (cur.left != null) {
          stack.push(cur.left);
          // Only for node without left child
        } else if (cur.right != null) {
          stack.push(cur.right);
        }
        // Traverse up the tree, left child handled; start handle right
      } else if (cur.left == prev) {
        if (cur.right != null) {
          stack.push(cur.right);
        }
        // Traverse up the tree, right child handled; start handle itself
      } else {
        result.add(cur.val);
        stack.pop();
      }
      prev = cur;
    }

    return result;
  }
}
