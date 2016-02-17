package binary_search_tree_iterator;

import java.util.ArrayList;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  private ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
  private int curr = 0;

  // Time consumption at construction time
  private void helper(ArrayList<TreeNode> list, TreeNode node) {
    if (node == null) {
      return;
    }
    helper(list, node.left);
    list.add(node);
    helper(list, node.right);
  }

  // @param root: The root of binary tree.
  public Solution(TreeNode root) {
    helper(inorder, root);
  }

  // @return: True if there has next node, or false
  public boolean hasNext() {
    return inorder.size() > 0 && curr != inorder.size();
  }

  // @return: return next node
  public TreeNode next() {
    return inorder.get(curr++);
  }
}
