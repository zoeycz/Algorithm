package maximum_product_subarray;

public class Solution {
  /**
   * @param nums: an array of integers
   * @return: an integer
   */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int rst = nums[0];
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    max[0] = nums[0];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max[i] = Math.max(nums[i], Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]));
      min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
      rst = Math.max(rst, max[i]);
    }
    return rst;
  }
}
