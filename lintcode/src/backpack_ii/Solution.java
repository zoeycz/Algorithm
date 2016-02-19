package backpack_ii;

public class Solution {
  /**
   * @param m: An integer m denotes the size of a backpack
   * @param A & V: Given n items with size A[i] and value V[i]
   * @return: The maximum value
   */
  public int backPackII(int m, int[] A, int V[]) {
    if (A == null || V == null || A.length == 0) {
      return 0;
    }

    int n = A.length;
    int[][] f = new int[n + 1][m + 1];
    f[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        f[i][j] = f[i - 1][j];
        if (j >= A[i - 1]) {
          f[i][j] = Math.max(f[i - 1][j - A[i - 1]] + V[i - 1], f[i][j]);
        }
      }
    }

    return f[n][m];
  }
}
