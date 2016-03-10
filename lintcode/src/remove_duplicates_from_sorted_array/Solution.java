package remove_duplicates_from_sorted_array;

public class Solution {
  /**
   * @param A: a array of integers
   * @return : return an integer
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int i = 0;
    int j = 1;
    while (j < nums.length) {
      while (j < nums.length && nums[j] == nums[i]) {
        j++;
      }
      i++;
      if (j == nums.length) {
        return i;
      } else {
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
