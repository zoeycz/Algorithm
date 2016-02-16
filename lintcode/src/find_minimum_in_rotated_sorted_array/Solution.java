package find_minimum_in_rotated_sorted_array;

public class Solution {
  /**
   * @param num: a rotated sorted array
   * @return: the minimum number in the array
   */
  public int findMin(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }

    int target = num[num.length - 1];
    int start = 0;
    int end = num.length - 1;
    int mid = (start + end) / 2;

    while (start + 1 < end) {
      if (num[mid] > target) {
        start = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }
    if (num[mid] < num[end]) {
      return num[mid];
    } else {
      return num[end];
    }
  }
}
