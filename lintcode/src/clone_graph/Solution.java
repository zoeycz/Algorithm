package clone_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
  /**
   * @param node: A undirected graph node
   * @return: A undirected graph node
   */
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }

    Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
    Map<UndirectedGraphNode, UndirectedGraphNode> map =
        new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

    UndirectedGraphNode node2 = new UndirectedGraphNode(node.label);
    map.put(node, node2);
    q.add(node);

    while (q.size() > 0) {
      UndirectedGraphNode curr = q.poll();
      UndirectedGraphNode curr1 = map.get(curr);
      if (curr.neighbors != null && curr.neighbors.size() > 0) {
        for (UndirectedGraphNode n : curr.neighbors) {
          UndirectedGraphNode n1 = map.get(n);
          if (n1 == null) {
            n1 = new UndirectedGraphNode(n.label);
            map.put(n, n1);
            q.add(n);
          }
          curr1.neighbors.add(n1);
        }
      }
    }

    return node2;
  }
}
