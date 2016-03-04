package slide_window_median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  // Note: Comparator<Integer>
  class MaxComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
      return y - x;
    }
  }

  /**
   * @param nums: A list of integers.
   * @return: The median of the element inside the window at each moving.
   */
  public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
    ArrayList<Integer> rst = new ArrayList<>();
    if (nums == null || nums.length == 0 || k < 1) {
      return rst;
    }
    if (nums.length <= k) {
      Arrays.sort(nums);
      rst.add(nums[nums.length / 2]);
      return rst;
    }
    if (k == 1) {
      for (int x : nums) {
        rst.add(x);
      }
      return rst;
    }

    // Two heaps, one max heap, to put in smaller half in the window, contains k/2 elements; one min
    // heap, to put in larger half, contains k-k/2

    // heap operation: insert, balance check, rebalance, delete
    int minLimit = k / 2;
    int maxLimit = k - k / 2;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(maxLimit + 1, new MaxComparator());

    int median = nums[0];
    maxHeap.add(median);
    for (int i = 1; i < nums.length; i++) {
      // delete
      if (i > k - 1) {
        if (nums[i - k] > median) {
          minHeap.remove(nums[i - k]);
        } else {
          maxHeap.remove(nums[i - k]);
        }
      }

      // add
      if (nums[i] < median) {
        maxHeap.add(nums[i]);
      } else {
        minHeap.add(nums[i]);
      }

      // rebalance
      while (minHeap.size() > minLimit) {
        maxHeap.add(minHeap.poll());
      }
      while (maxHeap.size() > maxLimit) {
        minHeap.add(maxHeap.poll());
      }

      // update median
      median = maxHeap.peek();
      if (i >= k - 1) {
        rst.add(median);
      }
    }

    return rst;
  }
}
