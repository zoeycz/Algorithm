package search_range_in_binary_search_tree;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree_inorder_traversal.TreeNode;

public class Solution2 {
  /**
   * @param root: The root of the binary search tree.
   * @param k1 and k2: range k1 to k2.
   * @return: Return all keys that k1<=key<=k2 in ascending order.
   */
  public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    // In order traversal
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode curr = root;

    // Push all left nodes
    while (curr != null) {
      stack.push(curr);
      curr = curr.left;
    }

    while (stack.size() > 0) {
      curr = stack.pop();
      if (curr.val > k2) {
        return res;
      } else if (curr.val >= k1 && curr.val <= k2) {
        res.add(curr.val);
      }
      if (curr.right != null) {
        curr = curr.right;

        // Push all left nodes
        while (curr != null) {
          stack.push(curr);
          curr = curr.left;
        }
      }
    }
    return res;
  }
}
