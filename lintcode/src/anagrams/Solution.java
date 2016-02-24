package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  /**
   * @param strs: A list of strings
   * @return: A list of strings
   */
  public List<String> anagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = Arrays.toString(arr);
      List<String> l = map.get(key);
      if (l == null) {
        l = new ArrayList<String>();
      }
      l.add(s);
      map.put(key, l);
    }
    List<String> rst = new ArrayList<String>();
    for (List<String> list : map.values()) {
      if (list.size() > 1) {
        rst.addAll(list);
      }
    }
    return rst;
  }
}
