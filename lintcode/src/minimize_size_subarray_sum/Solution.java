package minimize_size_subarray_sum;

public class Solution {
  /**
   * @param nums: an array of integers
   * @param s: an integer
   * @return: an integer representing the minimum size of subarray
   */
  public int minimumSize(int[] nums, int s) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int sum = 0;
    int min = Integer.MAX_VALUE;
    int end = 0;
    for (int start = 0; start < nums.length; start++) {
      while (end < nums.length && sum < s) {
        sum += nums[end++];
      }
      if (sum >= s) {
        min = Math.min(min, end - start);
      }
      sum -= nums[start];
    }
    if (min == Integer.MAX_VALUE) {
      return -1;
    }
    return min;
  }
}
