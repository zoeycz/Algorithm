package convert_bst_to_doubly_linked_list;

import binary_tree_inorder_traversal.TreeNode;

public class Solution {
  /**
   * @param root: The root of tree
   * @return: the head of doubly list node
   */
  public DoublyListNode bstToDoublyList(TreeNode root) {
    if (root == null) {
      return null;
    }
    DoublyListNode rst = new DoublyListNode(root.val);
    DoublyListNode left = bstToDoublyList(root.left);
    DoublyListNode right = bstToDoublyList(root.right);
    DoublyListNode tail = tail(left);
    rst.prev = tail;
    if (tail != null) {
      tail.next = rst;
    }
    rst.next = right;
    if (right != null) {
      right.prev = rst;
    }
    if (left != null) {
      return left;
    }
    return rst;
  }

  private DoublyListNode tail(DoublyListNode head) {
    while (head != null && head.next != null) {
      head = head.next;
    }
    return head;
  }
}

