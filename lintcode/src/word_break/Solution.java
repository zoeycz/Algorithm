package word_break;

import java.util.Set;

public class Solution {
  /**
   * @param s: A string s
   * @param dict: A dictionary of words dict
   */
  public boolean wordBreak(String s, Set<String> dict) {
    if (dict == null || s == null) {
      return false;
    }

    int maxLength = maxLength(dict);
    int n = s.length();
    boolean[] f = new boolean[n + 1];
    f[0] = true;

    for (int i = 1; i <= n; i++) {
      // j start from i-maxLength to save iteration times
      for (int j = Math.max(0, i - maxLength); j < i; j++) {
        if (f[j] && dict.contains(s.substring(j, i))) {
          f[i] = true;
        }
      }
    }
    return f[n];
  }

  private int maxLength(Set<String> dict) {
    int max = 0;
    for (String s : dict) {
      max = Math.max(s.length(), max);
    }
    return max;
  }
}
