package minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * @param source: A string
   * @param target: A string
   * @return: A string denote the minimum window Return "" if there is no such a string
   */
  public String minWindow(String source, String target) {
    if (source == null || target == null || source.length() < target.length()) {
      return "";
    }
    Map<Character, Integer> sCount = new HashMap<>();
    Map<Character, Integer> tCount = new HashMap<>();

    // init t count
    for (char c : target.toCharArray()) {
      if (tCount.containsKey(c)) {
        tCount.put(c, tCount.get(c) + 1);
      } else {
        tCount.put(c, 1);
      }
    }

    // move i, j index on source
    int i = 0;
    int j = 0;
    int minLen = Integer.MAX_VALUE;
    String s = "";
    for (i = 0; i < source.length(); i++) {
      while (j < source.length() && !valid(sCount, tCount)) {
        char c = source.charAt(j);
        if (sCount.containsKey(c)) {
          sCount.put(c, sCount.get(c) + 1);
        } else {
          sCount.put(c, 1);
        }
        j++;
      }
      if (valid(sCount, tCount) && j - i < minLen) {
        minLen = j - i;
        s = source.substring(i, j);
      }
      char start = source.charAt(i);
      sCount.put(start, sCount.get(start) - 1);
    }

    return s;
  }

  boolean valid(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
    for (char c : tCount.keySet()) {
      if (!sCount.containsKey(c) || tCount.get(c) > sCount.get(c)) {
        return false;
      }
    }
    return true;
  }
}
