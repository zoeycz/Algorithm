package convert_sortsed_list_to_balanced_bst;

import binary_tree_inorder_traversal.TreeNode;
import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param head: The first node of linked list.
   * @return: a tree node
   */
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode prev = getPreMid(head);
    TreeNode mid;
    if (prev.next == null) {
      mid = new TreeNode(prev.val);
    } else {
      mid = new TreeNode(prev.next.val);
      ListNode post = prev.next.next;
      prev.next = null;
      TreeNode left = sortedListToBST(head);
      TreeNode right = sortedListToBST(post);
      mid.left = left;
      mid.right = right;
    }

    return mid;
  }

  private ListNode getPreMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode mid = dummy;
    while (head != null && head.next != null) {
      mid = mid.next;
      head = head.next.next;
    }
    return mid;
  }
}

