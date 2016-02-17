package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: Level order a list of lists of integer
   */
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return res;
    }

    // Using one queue
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (queue.size() > 0) {
      ArrayList<Integer> level = new ArrayList<Integer>();
      // Note: remember the size of each level, no need for dummy node between levels
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        level.add(cur.val);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }

      res.add(level);
    }

    return res;
  }
}
