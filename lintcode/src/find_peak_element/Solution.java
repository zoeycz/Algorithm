package find_peak_element;

class Solution {
  /**
   * @param A: An integers array.
   * @return: return any of peek positions.
   */
  public int findPeak(int[] A) {
    if (A == null || A.length < 3) {
      return -1;
    }
    int start = 0;
    int end = A.length - 2;
    int mid = (start + end) / 2;
    while (start + 1 < end) {
      // Note: Understand the conditions of two if; the second if can merge with else
      if (A[mid] > A[mid - 1]) {
        start = mid;
      } else if (A[mid] > A[mid + 1]) {
        end = mid;
      } else {
        end = mid;
      }
      mid = (start + end) / 2;
    }
    if (A[start] < A[end]) {
      return end;
    } else {
      return start;
    }
  }
}

