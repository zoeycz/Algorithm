package merge_sorted_array;

class Solution {
  /**
   * Complexity: Time: O(m+n), Extra Space: O(1)
   * 
   * @param A: sorted integer array A which has m elements, but size of A is m+n
   * @param B: sorted integer array B which has n elements
   * @return: void
   */
  public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    if (A == null || B == null) {
      return;
    }
    for (int index = m + n - 1, i = m - 1, j = n - 1; index >= 0; index--) {
      if (i >= 0 && j >= 0) {
        if (A[i] > B[j]) {
          A[index] = A[i--];
        } else {
          A[index] = B[j--];
        }
      } else {
        if (i < 0) {
          A[index] = B[j--];
        }
      }
    }
  }
}
