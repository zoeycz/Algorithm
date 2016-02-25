package topological_sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
  /**
   * @param graph: A list of Directed graph node
   * @return: Any topological order for the given graph.
   */
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    if (graph == null) {
      return null;
    }
    ArrayList<DirectedGraphNode> rst = new ArrayList<DirectedGraphNode>();
    // Use a map to calculate arrows pointed to it
    // Use a queue to BFS the graph
    Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

    for (DirectedGraphNode node : graph) {
      if (node.neighbors != null && node.neighbors.size() > 0) {
        for (DirectedGraphNode n : node.neighbors) {
          if (map.get(n) != null) {
            map.put(n, map.get(n) + 1);
          } else {
            map.put(n, 1);
          }
        }
      }
    }

    for (DirectedGraphNode node : graph) {
      if (map.get(node) == null) {
        queue.add(node);
        rst.add(node);
      }
    }

    while (queue.size() > 0) {
      DirectedGraphNode node = queue.poll();
      for (DirectedGraphNode n : node.neighbors) {
        map.put(n, map.get(n) - 1);
        if (map.get(n) == 0) {
          queue.add(n);
          rst.add(n);
        }
      }
    }

    return rst;
  }
}
