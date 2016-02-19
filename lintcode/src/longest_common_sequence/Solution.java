package longest_common_sequence;

public class Solution {
  /**
   * @param A, B: Two strings.
   * @return: The length of longest common subsequence of A and B.
   */
  public int longestCommonSubsequence(String A, String B) {
    if (A == null || B == null || A.length() == 0 || B.length() == 0) {
      return 0;
    }
    int n = A.length();
    int m = B.length();

    int[][] match = new int[n + 1][m + 1];
    for (int i = 1; i < match.length; i++) {
      for (int j = 1; j < match[0].length; j++) {
        match[i][j] = Math.max(match[i - 1][j], match[i][j - 1]);
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          match[i][j] = match[i - 1][j - 1] + 1;
        }
      }
    }
    return match[n][m];
  }
}

