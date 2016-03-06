package partition_array_by_odd_and_even;

public class Solution {
  /**
   * @param nums: an array of integers
   * @return: nothing
   */
  public void partitionArray(int[] nums) {
    if (nums == null || nums.length < 0) {
      return;
    }
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      while (nums[left] % 2 == 1 && left < right) {
        left++;
      }
      while (nums[right] % 2 == 0 && left < right) {
        right--;
      }
      if (left < right) {
        swap(nums, left, right);
        left++;
        right--;
      }
    }
  }

  private void swap(int[] nums, int x, int y) {
    int tmp = nums[x];
    nums[x] = nums[y];
    nums[y] = tmp;
  }
}
