package recover_rotated_sorted_array;

import java.util.ArrayList;

public class Solution {
  /**
   * @param nums: The rotated sorted array
   * @return: void
   */
  public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return;
    }

    // Note: Cannot use binary search tree because possibility of equal value
    for (int i = 0; i < nums.size() - 1; i++) {
      if (nums.get(i) > nums.get(i + 1)) {
        reverse(0, i, nums);
        reverse(i + 1, nums.size() - 1, nums);
        reverse(0, nums.size() - 1, nums);
        return;
      }
    }
  }

  private void reverse(int start, int end, ArrayList<Integer> nums) {
    if (start >= end) {
      return;
    }
    for (int i = start, j = end; i < j; i++, j--) {
      int tmp = nums.get(i);
      nums.set(i, nums.get(j));
      nums.set(j, tmp);
    }
  }
}
