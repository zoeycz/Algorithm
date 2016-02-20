package reverse_node_in_k_group;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param head a ListNode
   * @param k an integer
   * @return a ListNode
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null) {
      head = reverse(head, k);
    }
    reverse(head, k);
    return dummy.next;
  }

  private ListNode reverse(ListNode head, int k) {
    // Don't handle if the remaining length is less than k
    ListNode next = head;
    for (int i = 0; i < k; i++) {
      if (next.next == null) {
        return next;
      }
      next = next.next;
    }

    ListNode n1 = head.next;
    ListNode curr = n1;
    ListNode tail = head;
    // Reverse within each group
    for (int i = 0; i < k; i++) {
      ListNode tmp = curr.next;
      curr.next = tail;
      tail = curr;
      curr = tmp;
    }
    // Handle dependency on ends
    n1.next = curr;
    head.next = tail;
    // Return the node before next group head so that can handle dependency on both ends
    return n1;
  }
}
