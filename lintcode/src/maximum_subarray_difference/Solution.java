package maximum_subarray_difference;

public class Solution {
  /**
   * @param nums: A list of integers
   * @return: An integer indicate the value of maximum difference between two Subarrays
   */
  public int maxDiffSubArrays(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int sum0 = 0;
    int sum1 = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int[][] left = new int[2][len];
    int[][] right = new int[2][len];

    for (int i = 0; i < len; i++) {
      sum0 += nums[i];
      sum1 += nums[i];
      min = Math.min(min, sum0);
      max = Math.max(max, sum1);
      if (sum0 > 0) {
        sum0 = 0;
      }
      if (sum1 < 0) {
        sum1 = 0;
      }
      left[0][i] = min;
      left[1][i] = max;
    }

    sum0 = 0;
    sum1 = 0;
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    for (int i = len - 1; i >= 0; i--) {
      sum0 += nums[i];
      sum1 += nums[i];
      min = Math.min(min, sum0);
      max = Math.max(max, sum1);
      if (sum0 > 0) {
        sum0 = 0;
      }
      if (sum1 < 0) {
        sum1 = 0;
      }
      right[0][i] = min;
      right[1][i] = max;
    }

    int rst = Integer.MIN_VALUE;
    for (int i = 0; i < len - 1; i++) {
      // Note: Watch out left with i and right with i+1, forever
      rst = Math.max(right[1][i + 1] - left[0][i], rst);
      rst = Math.max(left[1][i] - right[0][i + 1], rst);
    }
    return rst;
  }
}


