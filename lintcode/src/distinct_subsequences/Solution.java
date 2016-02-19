package distinct_subsequences;

public class Solution {
  /**
   * @param S, T: Two string.
   * @return: Count the number of distinct subsequences
   */
  public int numDistinct(String S, String T) {
    if (S == null || T == null) {
      return -1;
    }
    int n = S.length();
    int m = T.length();
    int[][] f = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      f[i][0] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        // Carry on the value if s(i) doesn't exist
        f[i][j] = f[i - 1][j];
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          // Add the combination s(i) match
          f[i][j] += f[i - 1][j - 1];
        }
      }
    }

    return f[n][m];
  }
}
