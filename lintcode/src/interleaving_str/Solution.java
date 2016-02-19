package interleaving_str;

public class Solution {
  /**
   * Determine whether s3 is formed by interleaving of s1 and s2.
   * 
   * @param s1, s2, s3: As description.
   * @return: true or false.
   */
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null) {
      return false;
    }
    int n = s1.length();
    int m = s2.length();
    int l = s3.length();
    boolean[][] f = new boolean[n + 1][m + 1];

    if (l == 0) {
      f[0][0] = true;
    }
    if (l != n + m) {
      return false;
    }

    for (int i = 1; i <= n; i++) {
      if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
        f[i][0] = true;
      }
    }

    for (int i = 1; i <= m; i++) {
      if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
        f[0][i] = true;
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        f[i][j] = f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
            || f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
      }
    }

    return f[n][m];
  }
}
