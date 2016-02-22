package maximum_subarray_ii;

import java.util.ArrayList;

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: An integer denotes the sum of max two non-overlapping subarrays
   */
  public int maxTwoSubArrays(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return 0;
    }
    int len = nums.size();
    int[] left = new int[len];
    int[] right = new int[len];

    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      sum += nums.get(i);
      max = Math.max(max, sum);
      if (sum < 0) {
        sum = 0;
      }
      left[i] = max;
    }

    sum = 0;
    max = Integer.MIN_VALUE;
    for (int i = len - 1; i >= 0; i--) {
      sum += nums.get(i);
      max = Math.max(max, sum);
      if (sum < 0) {
        sum = 0;
      }
      right[i] = max;
    }

    max = Integer.MIN_VALUE;
    for (int i = 0; i < len - 1; i++) {
      max = Math.max(max, left[i] + right[i + 1]);
    }
    return max;
  }
}


