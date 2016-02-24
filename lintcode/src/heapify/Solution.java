package heapify;

public class Solution {
  /**
   * @param A: Given an integer array
   * @return: void
   */
  public void heapify(int[] A) {
    if (A == null) {
      return;
    }
    for (int i = A.length / 2; i >= 0; i--) {
      siftdown(A, i);
    }
  }

  private void siftdown(int[] A, int k) {
    while (k < A.length) {
      int smallest = k;
      if (2 * k + 1 < A.length && A[2 * k + 1] < A[k]) {
        smallest = 2 * k + 1;
      }
      if (2 * k + 2 < A.length && A[2 * k + 2] < A[smallest]) {
        smallest = 2 * k + 2;
      }
      if (smallest == k) {
        break;
      }

      int tmp = A[k];
      A[k] = A[smallest];
      A[smallest] = tmp;
      k = smallest;
    }
  }
}
