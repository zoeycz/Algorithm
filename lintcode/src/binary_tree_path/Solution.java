package binary_tree_path;

import java.util.ArrayList;
import java.util.List;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root the root of the binary tree
   * @return all root-to-leaf paths
   */
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> rst = new ArrayList<String>();
    if (root == null) {
      return rst;
    }
    StringBuilder s = new StringBuilder();
    s.append(root.val);
    dfs(root, rst, s);
    return rst;
  }

  private void dfs(TreeNode node, List<String> rst, StringBuilder path) {
    if (node.left == null && node.right == null) {
      rst.add(path.toString());
      return;
    }
    if (node.left != null) {
      path.append(node.left.val);
      dfs(node.left, rst, path);
      path.deleteCharAt(path.length() - 1);
    }
    if (node.right != null) {
      path.append(node.right.val);
      dfs(node.right, rst, path);
      path.deleteCharAt(path.length() - 1);
    }
  }
}
