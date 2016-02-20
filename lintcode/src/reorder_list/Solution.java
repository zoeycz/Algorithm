package reorder_list;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param head: The head of linked list.
   * @return: void
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }

    // Find pre-mid and cut first half
    ListNode preM = preM(head);
    ListNode mid = preM.next;
    preM.next = null;

    // Reverse second half
    ListNode head2 = reverse(mid);

    // Merge both
    merge(head, head2);
  }

  private void merge(ListNode head, ListNode head2) {
    ListNode curr = new ListNode(0);
    boolean flag = true;
    while (head != null && head2 != null) {
      if (flag) {
        curr.next = head;
        head = head.next;
      } else {
        curr.next = head2;
        head2 = head2.next;
      }
      flag = !flag;
      curr = curr.next;
    }
    if (head == null) {
      curr.next = head2;
    } else {
      curr.next = head;
    }
  }

  private ListNode preM(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = head;
    ListNode mid = dummy;

    while (fast != null && fast.next != null) {
      mid = mid.next;
      fast = fast.next.next;
    }
    return mid;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode post = head.next;
    head.next = null;
    while (post != null) {
      ListNode tmp = post.next;
      post.next = head;
      head = post;
      post = tmp;
    }
    return head;
  }
}

