package copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * @param head: The head of linked list with a random pointer.
   * @return: A new head of a deep copy of the list.
   */
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return head;
    }

    RandomListNode dummy = new RandomListNode(0);
    RandomListNode curr = dummy;

    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    while (head != null) {
      curr.next = map.get(head);
      if (curr.next == null) {
        curr.next = new RandomListNode(head.label);
        map.put(head, curr.next);
      }
      curr = curr.next;
      curr.random = map.get(head.random);
      if (curr.random == null && head.random != null) {
        curr.random = new RandomListNode(head.random.label);
        map.put(head.random, curr.random);
      }
      head = head.next;
    }

    return dummy.next;
  }
}
