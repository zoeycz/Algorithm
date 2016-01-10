package strStr;

class Solution {
  /**
   * Returns a index to the first occurrence of target in source, or -1 if target is not part of
   * source.
   *
   * Source: http://www.lintcode.com/en/problem/strstr/
   *
   * Complexity: Time: O(n^2), Space: O(n)
   * 
   * Improvement: KMP Time: O(n)
   * 
   * @param source string to be scanned.
   * @param target string containing the sequence of characters to match.
   */
  public int strStr(String source, String target) {
    if (null == source || null == target) {
      return -1;
    }
    if (target.length() == 0) {
      return 0;
    }
    for (int i = 0; i < source.length() - target.length() + 1; i++) {
      for (int j = 0; j < target.length(); j++) {
        if (source.charAt(i + j) != target.charAt(j)) {
          break;
        }
        if (j == target.length() - 1) {
          return i;
        }
      }
    }
    return -1;
  }
}
