package partition_list;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param head: The first node of linked list.
   * @param x: an integer
   * @return: a ListNode
   */
  public ListNode partition(ListNode head, int x) {
    // Make two lists and join
    ListNode leftDummy = new ListNode(-1);
    ListNode rightDummy = new ListNode(-1);
    ListNode left = leftDummy;
    ListNode right = rightDummy;

    while (head != null) {
      if (head.val < x) {
        left.next = head;
        left = head;
      } else {
        right.next = head;
        right = head;
      }
      head = head.next;
    }

    // Note: Don't forget to set right.next to null to avoid infinity loop
    right.next = null;
    left.next = rightDummy.next;
    return leftDummy.next;
  }
}

