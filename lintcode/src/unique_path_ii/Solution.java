package unique_path_ii;

public class Solution {
  /**
   * @param obstacleGrid: A list of lists of integers
   * @return: An integer
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0) {
      return -1;
    }
    if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
      return -1;
    }
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
    int[][] f = new int[n][m];

    // Initialize
    f[0][0] = 1;

    for (int i = 1; i < n; i++) {
      if (obstacleGrid[i][0] == 1) {
        f[i][0] = 0;
      } else {
        f[i][0] = f[i - 1][0];
      }
    }

    for (int i = 1; i < m; i++) {
      if (obstacleGrid[0][i] == 1) {
        f[0][i] = 0;
      } else {
        f[0][i] = f[0][i - 1];
      }
    }

    // DP
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (obstacleGrid[i][j] == 1) {
          f[i][j] = 0;
        } else {
          f[i][j] = f[i - 1][j] + f[i][j - 1];
        }
      }
    }

    // Summarize
    return f[n - 1][m - 1];
  }
}
