package isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    Map<Character, Character> map1 = new HashMap<>();
    Map<Character, Character> map2 = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      char y = t.charAt(i);
      if (map1.containsKey(x) && map1.get(x) != y || map2.containsKey(y) && map2.get(y) != x) {
        return false;
      } else {
        map1.put(x, y);
        map2.put(y, x);
      }
    }
    return true;
  }
}
