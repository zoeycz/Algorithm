package first_position_of_target;

public class Solution {
  /**
   * Source: http://www.lintcode.com/en/problem/first-position-of-target/
   * 
   * Complexity: Time: O(log n), Space: O(1)
   * 
   * @param nums: The integer array.
   * @param target: Target to find.
   * @return: The first position of target. Position starts from 0.
   */
  public int binarySearch(int[] nums, int target) {
    if (nums != null && nums.length != 0) {
      int start = 0;
      int end = nums.length - 1;

      // Note: End with only one or two number
      while (start + 1 < end) {
        int mid = (start + end) / 2;

        // Note: Use '<' to leave the '==' case in else, and thus got the first position
        if (nums[mid] < target) {
          start = mid;
        } else {
          end = mid;
        }
      }

      // Note: nums[start] got to be checked first to get the first position
      if (nums[start] == target) {
        return start;
      }
      if (nums[end] == target) {
        return end;
      }
    }

    return -1;
  }
}
