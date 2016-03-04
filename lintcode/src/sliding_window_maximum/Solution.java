package sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {
  /**
   * @param nums: A list of integers.
   * @return: The maximum number inside the window at each moving.
   */
  public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    ArrayList<Integer> rst = new ArrayList<>();
    if (nums == null || nums.length == 0 || k < 1) {
      return rst;
    }

    // Note: Deque is abstract
    // This class is likely to be faster than Stack when used as a stack, and faster than LinkedList
    // when used as a queue.
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (deque.size() > 0 && nums[i] > deque.peekLast()) {
        deque.pollLast();
      }
      deque.offer(nums[i]);
      if (i > k - 1 && deque.peekFirst() == nums[i - k]) {
        deque.pollFirst();
      }
      if (i >= k - 1) {
        rst.add(deque.peekFirst());
      }
    }
    if (rst.size() == 0) {
      rst.add(deque.peekFirst());
    }
    return rst;
  }
}
