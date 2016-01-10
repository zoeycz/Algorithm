package classic_binary_search;

public class Solution {
  /**
   * Complexity: Time: O(log n), Space: O(1)
   * 
   * @param nums: The integer array.
   * @param target: Target to find.
   * @return: The first position of target. Position starts from 0.
   */
  public int binarySearch(int[] nums, int target) {
    int result = -1;

    if (nums != null && nums.length != 0) {
      int n = nums.length;
      int start = 0;
      int end = n - 1;
      int mid = (start + end) / 2;

      while (nums[mid] != target) {
        if (target < nums[mid]) {
          end = mid - 1;
          if (end < 0) {
            return -1;
          }
        } else {
          start = mid + 1;
          if (start == n) {
            return -1;
          }
        }
        mid = (start + end) / 2;
      }
      result = mid;
    }

    return result;
  }
}
