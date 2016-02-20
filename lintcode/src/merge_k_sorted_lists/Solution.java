package merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.List;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param lists: a list of ListNode
   * @return: The head of one sorted list.
   */
  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }
    if (lists.size() == 1) {
      return lists.get(0);
    }

    List<ListNode> resL = new ArrayList<ListNode>();
    for (int i = 0, j = lists.size() - 1; i <= j; i++, j--) {
      if (i == j) {
        resL.add(lists.get(i));
      } else {
        ListNode l1 = lists.get(i);
        ListNode l2 = lists.get(j);
        ListNode l = merge(l1, l2);
        resL.add(l);
      }
    }

    return mergeKLists(resL);
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    if (l1 == null) {
      curr.next = l2;
    } else {
      curr.next = l1;
    }
    return dummy.next;
  }
}
