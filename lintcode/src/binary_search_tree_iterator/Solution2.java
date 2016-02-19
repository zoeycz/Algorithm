package binary_search_tree_iterator;

import java.util.Stack;

import binary_tree_inorder_traversal.TreeNode;

public class Solution2 {
  private TreeNode curr;
  private Stack<TreeNode> stack;

  // @param root: The root of binary tree.
  public Solution2(TreeNode root) {
    stack = new Stack<TreeNode>();
    if (root == null) {
      return;
    }
    curr = root;
    stack.push(curr);
    while (curr.left != null) {
      stack.push(curr.left);
      curr = curr.left;
    }
  }

  // @return: True if there has next node, or false
  public boolean hasNext() {
    return stack.size() > 0;
  }

  // @return: return next node
  public TreeNode next() {
    curr = stack.pop();
    if (curr.right != null) {
      stack.push(curr.right);
      TreeNode node = curr.right;
      while (node.left != null) {
        stack.push(node.left);
        node = node.left;
      }
    }
    return curr;
  }
}
