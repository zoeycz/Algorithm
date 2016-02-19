package binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of binary tree.
   * @return: A list of lists of integer include the zigzag level order traversal of its nodes'
   *          values
   */
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    boolean reverse = true;
    TreeNode curr = root;
    queue.offer(curr);
    while (queue.size() > 0) {
      ArrayList<Integer> level = new ArrayList<Integer>();
      int size = queue.size();
      reverse = !reverse;
      for (int i = 0; i < size; i++) {
        curr = queue.poll();
        if (reverse) {
          level.add(0, curr.val);
        } else {
          level.add(curr.val);
        }
        if (curr.left != null) {
          queue.offer(curr.left);
        }
        if (curr.right != null) {
          queue.offer(curr.right);
        }
      }
      res.add(level);
    }
    return res;
  }
}
