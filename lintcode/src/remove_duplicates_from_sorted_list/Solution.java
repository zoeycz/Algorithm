package remove_duplicates_from_sorted_list;

public class Solution {
  /**
   * @param ListNode head is the head of the linked list
   * @return: ListNode head of the linked list
   */
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode prev = head;
    ListNode curr = head.next;
    while (curr != null) {
      if (prev.val == curr.val) {
        curr = curr.next;
        prev.next = curr;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }

    return head;
  }
}
