package sort_list;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param head: The head of linked list.
   * @return: You should return the head of the sorted linked list, using constant space complexity.
   */
  public ListNode sortList(ListNode head) {
    // Note: Initiate
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = findMid(head);
    // Note: Sort second part first, set mid.next to null to avoid infinity
    ListNode right = sortList(mid.next);
    mid.next = null;
    ListNode left = sortList(head);
    ListNode res = merge(left, right);
    return res;
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (left != null && right != null) {
      if (left.val <= right.val) {
        curr.next = left;
        curr = left;
        left = left.next;
      } else {
        curr.next = right;
        curr = right;
        right = right.next;
      }
    }

    if (left == null) {
      curr.next = right;
    } else {
      curr.next = left;
    }

    return dummy.next;
  }

  private ListNode findMid(ListNode start) {
    ListNode mid = start;
    // Note: Initiate
    start = start.next;
    while (start != null && start.next != null) {
      mid = mid.next;
      start = start.next.next;
    }
    return mid;
  }
}

