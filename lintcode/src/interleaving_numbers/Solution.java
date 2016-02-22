package interleaving_numbers;

import java.util.Arrays;

class Solution {
  /**
   * @param A: An integer array.
   * @return: void
   */
  public void rerange(int[] A) {
    if (A == null || A.length < 3) {
      return;
    }
    Arrays.sort(A);
    int i = 0;
    int j = A.length - 1;
    boolean swap = true;

    if (A.length % 2 == 1) {
      if (A[A.length / 2] > 0) {
        j--;
      } else {
        i++;
      }
    }

    while (i < j) {
      if (swap) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
      }
      i++;
      j--;
      swap = !swap;
    }
  }
}
