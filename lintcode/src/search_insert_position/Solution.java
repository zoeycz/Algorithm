package search_insert_position;

public class Solution {
  /**
   * param A : an integer sorted array param target : an integer to be inserted return : an integer
   */
  public int searchInsert(int[] A, int target) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int start = 0;
    int end = A.length - 1;
    int mid = (start + end) / 2;

    while (start + 1 < end) {
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }

    if (A[start] >= target) {
      return start;
    } else if (A[end] >= target) {
      return end;
    } else {
      // Note: Check all corner cases
      return end + 1;
    }
  }
}
