package kth_largest_element;

class Solution {
  /*
   * @param k : description of k
   * 
   * @param nums : array of nums
   * 
   * @return: description of return
   */
  public int kthLargestElement(int k, int[] nums) {
    if (nums == null || nums.length == 0 || k > nums.length) {
      return 0;
    }
    return helper(0, nums.length - 1, k, nums);
  }

  /*
   * Use the last element as anchor, larger ones goes to front, smaller ones goes to back; Compare k
   * and anchor position and sort the rest accordingly
   */
  private int helper(int start, int end, int k, int[] nums) {
    int anchor = nums[end];
    int i = start;
    int j = end - 1;
    while (i < j) {
      if (nums[i] <= anchor) {
        swap(i, j, nums);
        j--;
      } else {
        i++;
      }
    }
    if (nums[i] <= anchor) {
      swap(i, end, nums);
    } else {
      i++;
      swap(i, end, nums);
    }

    if (i == k - 1) {
      return nums[i];
    } else if (i < k - 1) {
      return helper(i + 1, end, k, nums);
    } else {
      return helper(start, i - 1, k, nums);
    }
  }

  private void swap(int x, int y, int[] nums) {
    int tmp = nums[x];
    nums[x] = nums[y];
    nums[y] = tmp;
  }
};
