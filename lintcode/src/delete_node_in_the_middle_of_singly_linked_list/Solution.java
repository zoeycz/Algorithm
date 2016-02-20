package delete_node_in_the_middle_of_singly_linked_list;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param node: the node in the list should be deleted
   * @return: nothing
   */
  public void deleteNode(ListNode node) {
    if (node == null) {
      return;
    }
    ListNode prev = node;
    while (node.next != null) {
      node.val = node.next.val;
      prev = node;
      node = node.next;
    }
    prev.next = null;
  }
}
