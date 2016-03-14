package repeated_dna_sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> rst = new ArrayList<String>();
    if (s == null || s.length() == 0) {
      return rst;
    }
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i + 10 <= s.length(); i++) {
      String tmp = s.substring(i, i + 10);
      if (map.containsKey(tmp)) {
        int x = map.get(tmp);
        if (x == 1) {
          rst.add(tmp);
        }
        map.put(tmp, x + 1);
      } else {
        map.put(tmp, 1);
      }
    }
    return rst;
  }
}
