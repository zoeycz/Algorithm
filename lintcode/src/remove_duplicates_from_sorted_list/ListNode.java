package remove_duplicates_from_sorted_list;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  static public ListNode makeList(int[] vals) {
    ListNode head = new ListNode(vals[0]);
    ListNode prev = head;

    for (int i = 1; i < vals.length; i++) {
      ListNode curr = new ListNode(vals[i]);
      prev.next = curr;
      prev = curr;
    }

    return head;
  }

  static public void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " - ");
      head = head.next;
    }
    System.out.println();
  }
}
