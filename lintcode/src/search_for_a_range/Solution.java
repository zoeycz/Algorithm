package search_for_a_range;

public class Solution {
  /**
   * @param A : an integer sorted array
   * @param target : an integer to be inserted return : a list of length 2, [index1, index2]
   */
  public int[] searchRange(int[] A, int target) {
    int[] range = {-1, -1};

    if (A == null || A.length == 0 || A[0] > target || A[A.length - 1] < target) {
      // Note: can't return [-1, -1] directly
      return range;
    }

    int start = 0;
    int end = A.length - 1;
    int mid = (start + end) / 2;
    while (start + 1 < end) {
      if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }
    if (A[mid] == target) {
      range[0] = mid;
    } else if (A[end] == target) {
      range[0] = end;
    } else {
      return range;
    }

    end = A.length - 1;
    mid = (start + end) / 2;
    while (start + 1 < end) {
      if (A[mid] <= target) {
        start = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }
    if (A[end] == target) {
      range[1] = end;
    } else {
      range[1] = mid;
    }
    return range;
  }
}

