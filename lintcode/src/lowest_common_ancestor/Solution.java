package lowest_common_ancestor;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of the binary search tree.
   * @param A and B: two nodes in a Binary.
   * @return: Return the least common ancestor(LCA) of the two nodes.
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    // End condition
    if (root == null || root.val == A.val || root.val == B.val) {
      return root;
    }

    // Post order traversal, children first
    TreeNode left = lowestCommonAncestor(root.left, A, B);
    TreeNode right = lowestCommonAncestor(root.right, A, B);

    // Summarize result from children and return
    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    } else {
      return null;
    }
  }
}
