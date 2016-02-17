package unique_paths;

public class Solution {
  /**
   * @param n, m: positive integer (1 <= n ,m <= 100)
   * @return an integer
   */
  public int uniquePaths(int m, int n) {
    int[][] f = new int[n][m];
    // Initialize
    for (int i = 0; i < m; i++) {
      f[0][i] = 1;
    }
    for (int i = 0; i < n; i++) {
      f[i][0] = 1;
    }

    // DP: [i, j] = [i-1, j] + [i, j-1]
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        f[i][j] = f[i - 1][j] + f[i][j - 1];
      }
    }

    // Summarize
    return f[n - 1][m - 1];
  }
}

