package jump_game_ii;

public class Solution {
  /**
   * @param A: A list of lists of integers
   * @return: An integer
   */
  public int jump(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int n = A.length;
    int[] f = new int[n];
    for (int i = 0; i < n; i++) {
      f[i] = Integer.MAX_VALUE;
    }

    // f[i] represents min step # to reach i
    f[0] = 0;
    // for each position, recalculate min # for steps can be reached from here
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j <= i + A[i] && j < n; j++) {
        f[j] = Math.min(f[j], f[i] + 1);
      }
    }
    return f[n - 1];
  }
}

