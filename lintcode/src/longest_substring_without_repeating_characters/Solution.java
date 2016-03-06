package longest_substring_without_repeating_characters;

import java.util.HashMap;

public class Solution {
  /**
   * @param s: a string
   * @return: an integer
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    // slow pointer, i, at the start
    // fast pointer, j, go forward and put char into hashmap
    // if encounter same, record current length, move i
    int i = 0;
    int j = 0;
    int max = Integer.MIN_VALUE;
    HashMap<Character, Integer> map = new HashMap<>();
    while (i < s.length()) {
      while (j < s.length() && !map.containsKey(s.charAt(j))) {
        map.put(s.charAt(j), j);
        j++;
      }
      max = Math.max(max, j - i);
      if (j == s.length()) {
        return max;
      }
      int pos = map.get(s.charAt(j));
      while (i <= pos) {
        map.remove(s.charAt(i));
        i++;
      }
    }
    return 0;
  }
}
