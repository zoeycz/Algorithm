package insert_node_in_a_binary_search_tree;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of the binary search tree.
   * @param node: insert this node into the binary search tree
   * @return: The root of the new binary search tree.
   */
  public TreeNode insertNode(TreeNode root, TreeNode node) {
    if (root == null) {
      return node;
    }
    helper(root, node);
    return root;
  }

  private void helper(TreeNode root, TreeNode node) {
    // Note: Java pass object by value of its address; if change root value, it will change back
    // when return to its caller; but if change the object it points to, the object will show the
    // difference when return to its caller
    if (root.val > node.val) {
      if (root.left == null) {
        root.left = node;
        return;
      } else {
        helper(root.left, node);
      }
    } else {
      if (root.right == null) {
        root.right = node;
        return;
      } else {
        helper(root.right, node);
      }
    }
  }
}
