package the_smallest_differences;

import java.util.Arrays;

public class Solution {
  /**
   * @param A, B: Two integer arrays.
   * @return: Their smallest difference.
   */
  public int smallestDifference(int[] A, int[] B) {
    if (A == null || B == null || A.length == 0 || B.length == 0) {
      return -1;
    }
    int min = Integer.MAX_VALUE;
    Arrays.sort(A);
    Arrays.sort(B);
    for (int i = 0, j = 0; i < A.length && j < B.length;) {
      min = Math.min(min, Math.abs(A[i] - B[j]));
      if (min == 0) {
        return 0;
      }
      if (A[i] < B[j]) {
        i++;
      } else {
        j++;
      }
    }
    return min;
  }
}

