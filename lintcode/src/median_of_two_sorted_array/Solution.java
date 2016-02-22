package median_of_two_sorted_array;

class Solution {
  /**
   * @param A: An integer array.
   * @param B: An integer array.
   * @return: a double whose format is *.5 or *.0
   */
  public double findMedianSortedArrays(int[] A, int[] B) {
    if (A == null || B == null) {
      return 0.0;
    }
    int len = A.length + B.length;
    if (len % 2 == 1) {
      return findKth(A, 0, B, 0, len / 2 + 1);
    } else {
      return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }
  }

  // Note: k is the kth number, not the index in array, as index in array will lose info in process
  private int findKth(int[] A, int astart, int[] B, int bstart, int k) {
    if (astart >= A.length) {
      return B[bstart + k - 1];
    }
    if (bstart >= B.length) {
      return A[astart + k - 1];
    }

    // Note: end criteria
    if (k == 1) {
      return Math.min(A[astart], B[bstart]);
    }

    // Note: assign A[x] value to akey for comparison
    int akey = astart + k / 2 - 1 < A.length ? A[astart + k / 2 - 1] : Integer.MAX_VALUE;
    int bkey = bstart + k / 2 - 1 < B.length ? B[bstart + k / 2 - 1] : Integer.MAX_VALUE;

    // Note: the number used in recursive function
    if (akey < bkey) {
      return findKth(A, astart + k / 2, B, bstart, k - k / 2);
    } else {
      return findKth(A, astart, B, bstart + k / 2, k - k / 2);
    }
  }
}

