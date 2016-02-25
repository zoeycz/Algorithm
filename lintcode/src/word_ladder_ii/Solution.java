package word_ladder_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
  /**
   * @param start, a string
   * @param end, a string
   * @param dict, a set of string
   * @return a list of lists of string
   */
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    List<List<String>> rst = new ArrayList<List<String>>();
    if (dict == null) {
      return rst;
    }
    dict.add(start);
    dict.add(end);

    // BFS to get distance list
    Map<String, Integer> distance = new HashMap<String, Integer>();
    Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
    int length = bfs(start, end, dict, distance, neighbors);

    // DFS to get result
    List<String> list = new ArrayList<String>();
    list.add(start);
    dfs(rst, list, distance, neighbors, length, end);
    return rst;
  }

  private void dfs(List<List<String>> rst, List<String> list, Map<String, Integer> distance,
      Map<String, List<String>> neighbors, int length, String end) {
    if (list.size() == length) {
      if (list.get(list.size() - 1).equals(end)) {
        rst.add(new ArrayList<String>(list));
      }
      return;
    }

    String last = list.get(list.size() - 1);
    for (String s : neighbors.get(last)) {
      // Note: necessity of null comparison. bfs stop early to save time
      if (distance.get(s) == null || distance.get(s) != list.size() + 1) {
        continue;
      }
      list.add(s);
      dfs(rst, list, distance, neighbors, length, end);
      list.remove(list.size() - 1);
    }
  }

  private int bfs(String start, String end, Set<String> dict, Map<String, Integer> distance,
      Map<String, List<String>> neighbors) {

    Set<String> visited = new HashSet<String>();
    Queue<String> queue = new LinkedList<String>();
    int length = 0;
    queue.add(start);
    visited.add(start);

    while (queue.size() > 0) {
      length++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        distance.put(curr, length);
        List<String> nbs = neighbor(curr, dict);
        neighbors.put(curr, nbs);
        if (curr.equals(end)) {
          return length;
        }
        for (String s : nbs) {
          if (!visited.contains(s)) {
            queue.add(s);
            visited.add(s);
          }
        }
      }
    }

    return 0;
  }

  private List<String> neighbor(String node, Set<String> dict) {
    List<String> rst = new ArrayList<String>();
    for (int i = 0; i < node.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        if (c == node.charAt(i)) {
          continue;
        }
        String s = node.substring(0, i) + c + node.substring(i + 1, node.length());
        if (dict.contains(s)) {
          rst.add(s);
        }
      }
    }
    return rst;
  }
}
