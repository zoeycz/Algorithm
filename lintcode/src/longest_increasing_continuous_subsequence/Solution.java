package longest_increasing_continuous_subsequence;

public class Solution {
  /**
   * @param A an array of Integer
   * @return an integer
   */
  public int longestIncreasingContinuousSubsequence(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int n = A.length;
    int[] forward = new int[n];
    int[] backward = new int[n];
    forward[0] = 1;
    backward[n - 1] = 1;
    int max = 1;
    for (int i = 1; i < n; i++) {
      if (A[i] > A[i - 1]) {
        forward[i] = forward[i - 1] + 1;
        max = Math.max(max, forward[i]);
      } else {
        forward[i] = 1;
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      if (A[i] > A[i + 1]) {
        backward[i] = backward[i + 1] + 1;
        max = Math.max(max, backward[i]);
      } else {
        backward[i] = 1;
      }
    }

    return max;
  }
}
