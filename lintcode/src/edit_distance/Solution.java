package edit_distance;

public class Solution {
  /**
   * @param word1 & word2: Two string.
   * @return: The minimum number of steps.
   */
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    int n = word1.length();
    int m = word2.length();
    int[][] f = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      f[i][0] = i;
    }
    for (int j = 1; j <= m; j++) {
      f[0][j] = j;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + 1;
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          f[i][j] = Math.min(f[i - 1][j - 1], f[i][j]);
        } else {
          f[i][j] = Math.min(f[i - 1][j - 1] + 1, f[i][j]);
        }
      }
    }

    return f[n][m];
  }
}
