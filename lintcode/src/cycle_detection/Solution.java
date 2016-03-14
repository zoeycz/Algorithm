package cycle_detection;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  Set<String> getDeps(String start, Map<String, List<String>> map) throws Exception {
    Set<String> rst = new HashSet<String>();
    dfs(rst, new HashSet<String>(), start, map);
    rst.remove(start);
    return rst;
  }

  void dfs(Set<String> rst, Set<String> path, String node, Map<String, List<String>> map)
      throws Exception {
    if (!map.containsKey(node)) {
      return;
    }
    for (String curr : map.get(node)) {
      if (path.contains(curr)) {
        throw new Exception("Cycle detected");
      }
      if (rst.contains(curr)) {
        continue;
      }
      rst.add(curr);
      path.add(curr);
      dfs(rst, path, curr, map);
      path.remove(curr);
    }
  }
}
