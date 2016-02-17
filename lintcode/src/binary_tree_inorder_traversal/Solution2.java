package binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
  /**
   * @param root: The root of binary tree.
   * @return: Inorder in ArrayList which contains node values.
   */
  public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    // Note: push left not in main loop
    // Initialize stack, so that while loop can take stack size as end condition
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }

    while (stack.size() > 0) {
      // All left child handled, handle itself
      cur = stack.pop();
      result.add(cur.val);

      // First time see right child, push it and all its left child, so that left child will be
      // handle first
      if (cur.right != null) {
        TreeNode l = cur.right;
        while (l != null) {
          stack.push(l);
          l = l.left;
        }
      }
    }
    return result;
  }
}
