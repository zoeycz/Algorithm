package binary_tree_maximum_path_sum;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  class PathNode {
    int singlePath, maxPath;

    PathNode(int singlePath, int maxPath) {
      this.singlePath = singlePath; // Can contain nothing
      this.maxPath = maxPath; // Have to contain at least one node
    }
  }

  // Post order traversal
  private PathNode helper(TreeNode root) {
    if (root == null) {
      return new PathNode(0, Integer.MIN_VALUE);
    }
    PathNode left = helper(root.left);
    PathNode right = helper(root.right);

    // singlePath = max(left + me , right + me, 0)
    int singlePath = Math.max(left.singlePath + root.val, right.singlePath + root.val);
    singlePath = Math.max(0, singlePath);

    // maxPath = max path through(left, right, me)
    int maxPath = Math.max(left.maxPath, right.maxPath);
    maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

    return new PathNode(singlePath, maxPath);
  }

  /**
   * @param root: The root of binary tree.
   * @return: An integer.
   */
  public int maxPathSum(TreeNode root) {
    PathNode res = helper(root);
    return res.maxPath;
  }
}
