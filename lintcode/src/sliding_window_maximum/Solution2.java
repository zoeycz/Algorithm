package sliding_window_maximum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
  class MaxComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
      return y - x;
    }
  }

  /**
   * @param nums: A list of integers.
   * @return: The maximum number inside the window at each moving.
   */
  public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    ArrayList<Integer> rst = new ArrayList<>();
    if (nums == null || nums.length == 0 || k < 1) {
      return rst;
    }
    // max heap
    PriorityQueue<Integer> heap = new PriorityQueue<>(k, new MaxComparator());
    // delete, add, get
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > k - 1) {
        heap.remove(nums[i - k]);
      }
      heap.add(nums[i]);
      max = heap.peek();
      if (i >= k - 1) {
        rst.add(max);
      }
    }
    if (rst.size() == 0) {
      rst.add(max);
    }
    return rst;
  }
}

