package search_in_rotated_sorted_array;

public class Solution {
  /**
   * @param A : an integer rotated sorted array
   * @param target : an integer to be searched return : an integer
   */
  public int search(int[] A, int target) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int start = 0;
    int end = A.length - 1;
    int mid = (start + end) / 2;
    while (start + 1 < end) {
      if (A[mid] == target) {
        return mid;
      } else if (A[start] < A[mid]) {
        if (target < A[start] || target > A[mid]) {
          start = mid;
        } else {
          end = mid;
        }
      } else {
        if (target > A[mid] && target < A[start]) {
          start = mid;
        } else {
          end = mid;
        }
      }
      mid = (start + end) / 2;
    }
    if (A[mid] == target) {
      return mid;
    } else if (A[end] == target) {
      return end;
    } else {
      return -1;
    }
  }
}

