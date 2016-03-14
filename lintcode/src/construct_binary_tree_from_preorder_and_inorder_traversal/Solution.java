package construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

import binary_tree_inorder_traversal.TreeNode;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public TreeNode left, right;
 * public TreeNode(int val) { this.val = val; this.left = this.right = null; } }
 */


public class Solution {
  /**
   * @param preorder : A list of integers that preorder traversal of a tree
   * @param inorder : A list of integers that inorder traversal of a tree
   * @return : Root of a tree
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0
        || preorder.length != inorder.length) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode helper(Map<Integer, Integer> map, int[] preorder, int pStart, int pEnd,
      int[] inorder, int iStart, int iEnd) {
    if (iStart > iEnd) {
      return null;
    }
    int now = preorder[pStart];
    TreeNode root = new TreeNode(now);
    int pos = map.get(now);
    root.left = helper(map, preorder, pStart + 1, pos - iStart + pStart, inorder, iStart, pos - 1);
    root.right = helper(map, preorder, pos + 1 - iEnd + pEnd, pEnd, inorder, pos + 1, iEnd);
    return root;
  }
}
