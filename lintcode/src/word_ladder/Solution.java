package word_ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
  /**
   * @param start, a string
   * @param end, a string
   * @param dict, a set of string
   * @return an integer
   */
  public int ladderLength(String start, String end, Set<String> dict) {
    if (dict == null) {
      return 0;
    }
    dict.add(start);
    dict.add(end);
    // bfs from start and calculate distant till end
    Queue<String> queue = new LinkedList<String>();
    Set<String> visited = new HashSet<String>();
    int distance = 0;
    queue.add(start);
    visited.add(start);

    while (queue.size() > 0) {
      int size = queue.size();
      distance++;
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (curr.equals(end)) {
          return distance;
        }
        for (String s : neighbors(curr, dict)) {
          if (!visited.contains(s)) {
            queue.add(s);
            visited.add(s);
          }
        }
      }
    }

    return 0;
  }

  private List<String> neighbors(String curr, Set<String> dict) {
    List<String> rst = new ArrayList<String>();
    for (int i = 0; i < curr.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        if (c == curr.charAt(i)) {
          continue;
        }
        String s = curr.substring(0, i) + c + curr.substring(i + 1, curr.length());
        if (dict.contains(s)) {
          rst.add(s);
        }
      }
    }
    return rst;
  }
}
