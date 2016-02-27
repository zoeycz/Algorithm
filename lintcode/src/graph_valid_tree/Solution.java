package graph_valid_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  /**
   * @param n an integer
   * @param edges a list of undirected edges
   * @return true if it's a valid tree, or false
   */
  public boolean validTree(int n, int[][] edges) {
    if (n == 0 || n == 1 && edges.length == 0) {
      return true;
    }
    if (edges == null || edges.length != n - 1 || edges[0].length != 2) {
      return false;
    }

    // No loop, two ends of the new edge should not belong to the same connected graph

    // Initial, all integers have their own set
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      for (int point : edge) {
        if (!map.containsKey(point)) {
          Set<Integer> set = new HashSet<Integer>();
          set.add(point);
          map.put(point, set);
        }
      }
    }

    // Add edge, check if belong to the same set; if not, converge
    for (int[] edge : edges) {
      if (map.get(edge[0]) == map.get(edge[1])) {
        return false;
      }
      Set<Integer> set0 = map.get(edge[0]);
      Set<Integer> set1 = map.get(edge[1]);
      Set<Integer> set = new HashSet<>();
      set.addAll(set0);
      set.addAll(set1);
      for (int x : set0) {
        map.put(x, set);
      }
      for (int x : set1) {
        map.put(x, set);
      }
    }

    return true;
  }
}
