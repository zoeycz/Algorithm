package partition_array;

public class Solution {
  /**
   * @param nums: The integer array you should partition
   * @param k: As description return: The index after partition
   */
  public int partitionArray(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      while (nums[left] < k && left < right) {
        left++;
      }
      while (nums[right] >= k && left < right) {
        right--;
      }
      if (left < right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
      }
    }

    if (nums[left] < k) {
      return left + 1;
    }

    return left;
  }
}
