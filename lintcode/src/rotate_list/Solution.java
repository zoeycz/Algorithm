package rotate_list;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param head: the List
   * @param k: rotate to the right k places
   * @return: the list after rotation
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < k; i++) {
      if (fast.next == null) {
        fast = head;
      } else {
        fast = fast.next;
      }
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    fast.next = head;
    head = slow.next;
    slow.next = null;

    return head;
  }
}
