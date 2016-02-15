package palindrom_partition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /**
   * @param s: A string
   * @return: A list of lists of string
   */
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<List<String>>();
    if (s == null || s.length() == 0) {
      return res;
    }
    List<String> list = new ArrayList<String>();
    helper(res, list, s, 0);
    return res;
  }

  private void helper(List<List<String>> res, List<String> list, String s, int pos) {
    if (pos == s.length()) {
      res.add(new ArrayList<String>(list));
      return;
    }

    // Note: i as end of next string
    for (int i = pos + 1; i <= s.length(); i++) {
      String ss = s.substring(pos, i);
      if (!isPalindrome(ss)) {
        continue;
      }
      list.add(ss);
      helper(res, list, s, i);
      list.remove(list.size() - 1);
    }
  }

  private boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
