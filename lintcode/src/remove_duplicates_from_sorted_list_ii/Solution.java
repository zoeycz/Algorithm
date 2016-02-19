package remove_duplicates_from_sorted_list_ii;

public class Solution {
  /**
   * Complexity: Time: O(n), Extra Space: O(1)
   * 
   * @param ListNode head is the head of the linked list
   * @return: ListNode head of the linked list
   */
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    head = dummy;

    while (head.next != null && head.next.next != null) {
      if (head.next.val == head.next.next.val) {
        int val = head.next.val;
        while (head.next != null && head.next.val == val) {
          head.next = head.next.next;
        }
      } else {
        head = head.next;
      }
    }

    return dummy.next;
  }
}

