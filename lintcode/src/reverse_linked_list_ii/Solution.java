package reverse_linked_list_ii;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param ListNode head is the head of the linked list
   * @param m and n
   * @return: The head of the reversed ListNode
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head != null && n == m) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    head = dummy;
    for (int i = 1; i < m; i++) {
      if (head == null) {
        return null;
      }
      head = head.next;
    }

    if (head.next == null) {
      return null;
    }
    ListNode prem = head;
    ListNode mm = head.next;
    ListNode nn = mm;
    ListNode postn = nn.next;

    for (int i = m; i < n; i++) {
      if (postn == null) {
        return null;
      }
      ListNode tmp = postn.next;
      postn.next = nn;
      nn = postn;
      postn = tmp;
    }

    mm.next = postn;
    prem.next = nn;

    return dummy.next;
  }
}
