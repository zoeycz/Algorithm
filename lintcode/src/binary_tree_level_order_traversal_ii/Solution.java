package binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: buttom-up level order a list of lists of integer
   */
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (queue.size() > 0) {
      ArrayList<Integer> level = new ArrayList<Integer>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        // Note: cur.val instead of cur
        level.add(cur.val);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      res.add(0, level);
    }

    return res;
  }
}
