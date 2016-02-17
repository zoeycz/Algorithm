package search_range_in_binary_search_tree;

import java.util.ArrayList;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of the binary search tree.
   * @param k1 and k2: range k1 to k2.
   * @return: Return all keys that k1<=key<=k2 in ascending order.
   */
  public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    // In order traversal
    ArrayList<Integer> res = new ArrayList<Integer>();
    helper(res, root, k1, k2);
    return res;
  }

  private void helper(ArrayList<Integer> res, TreeNode node, int k1, int k2) {
    if (node == null) {
      return;
    }
    helper(res, node.left, k1, k2);
    // Skip traversal after k2
    if (node.val > k2) {
      return;
    }
    if (node.val >= k1 && node.val <= k2) {
      res.add(node.val);
    }
    helper(res, node.right, k1, k2);
  }
}
