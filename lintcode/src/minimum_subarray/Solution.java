package minimum_subarray;

import java.util.ArrayList;

public class Solution {
  /**
   * @param nums: a list of integers
   * @return: A integer indicate the sum of minimum subarray
   */
  public int minSubArray(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return 0;
    }

    int sum = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      min = Math.min(min, sum);
      if (sum > 0) {
        sum = 0;
      }
    }

    return min;
  }
}

