package merge_sorted_array_ii;

class Solution {
  /**
   * @param A and B: sorted integer array A and B.
   * @return: A new sorted integer array
   */
  public int[] mergeSortedArray(int[] A, int[] B) {
    if (A == null || B == null) {
      return null;
    }
    int m = A.length;
    int n = B.length;
    int[] rst = new int[m + n];

    for (int i = 0, j = 0; i + j < m + n;) {
      if (i < m && j < n) {
        if (A[i] < B[j]) {
          rst[i + j] = A[i++];
        } else {
          rst[i + j] = B[j++];
        }
      } else if (i >= m) {
        rst[i + j] = B[j++];
      } else {
        rst[i + j] = A[i++];
      }
    }
    return rst;
  }
}
