package sort_colors;

class Solution {
  /**
   * @param nums: A list of integer which is 0, 1 or 2
   * @return: nothing
   */
  public void sortColors(int[] nums) {
    if (nums == null || nums.length < 2) {
      return;
    }

    int left = 0;
    int right = nums.length - 1;
    int i = left;

    while (i <= right) {
      if (nums[i] == 0) {
        swap(nums, left, i);
        i++;
        left++;
      } else if (nums[i] == 1) {
        i++;
      } else {
        swap(nums, i, right);
        right--;
        // Note: No i++ here; Leave it to fix number if not 2 got swap over
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
