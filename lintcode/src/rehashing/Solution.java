package rehashing;

import remove_duplicates_from_sorted_list.ListNode;

public class Solution {
  /**
   * @param hashTable: A list of The first node of linked list
   * @return: A list of The first node of linked list which have twice size
   */
  public ListNode[] rehashing(ListNode[] hashTable) {
    if (hashTable == null) {
      return null;
    }
    int size = 2 * hashTable.length;

    ListNode[] rst = new ListNode[size];
    for (ListNode node : hashTable) {
      while (node != null) {
        // rehash node
        int hash = ((node.val % size) + size) % size;
        ListNode n = rst[hash];
        if (n == null) {
          rst[hash] = new ListNode(node.val);
        } else {
          while (n.next != null) {
            n = n.next;
          }
          n.next = new ListNode(node.val);
        }
        // rehash its collision
        node = node.next;
      }
    }

    return rst;
  }
};

