package insert_node_in_a_binary_search_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution2 {
  /**
   * @param root: The root of the binary search tree.
   * @param node: insert this node into the binary search tree
   * @return: The root of the new binary search tree.
   */
  public TreeNode insertNode(TreeNode root, TreeNode node) {
    if (root == null) {
      return node;
    }
    TreeNode curr = root;
    // Note: all variable equal to null point to null; when assign another value for it, it point to
    // something else; this value won't be passed to other variables; b in following example will
    // still be null

    // TreeNode a = null;
    // TreeNode b = a;
    // a = new TreeNode(1);

    while (curr != null) {
      if (node.val < curr.val) {
        if (curr.left == null) {
          curr.left = node;
          return root;
        } else {
          curr = curr.left;
        }
      } else {
        if (curr.right == null) {
          curr.right = node;
          return root;
        } else {
          curr = curr.right;
        }
      }
    }
    return root;
  }
}
