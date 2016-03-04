package trapping_rain_water;

import java.util.PriorityQueue;

public class Solution {
  /**
   * @param heights: an array of integers
   * @return: a integer
   */
  class Node implements Comparable<Node> {
    int position;
    int height;

    Node(int pos, int h) {
      this.position = pos;
      this.height = h;
    }

    public int compareTo(Node node) {
      if (this.height == node.height) {
        return node.position - this.position;
      }
      return this.height - node.height;
    }
  }

  private int[] dx = {1, -1};

  public int trapRainWater(int[] heights) {
    if (heights == null || heights.length < 3) {
      return 0;
    }
    int sum = 0;
    int n = heights.length;
    int[] visited = new int[heights.length];
    PriorityQueue<Node> heap = new PriorityQueue<>();

    heap.add(new Node(0, heights[0]));
    heap.add(new Node(n - 1, heights[n - 1]));
    visited[0] = 1;
    visited[n - 1] = 1;

    while (heap.size() > 0) {
      Node curr = heap.poll();
      for (int x : dx) {
        int pos = curr.position + x;
        if (pos >= 0 && pos < n && visited[pos] == 0) {
          sum += Math.max(0, curr.height - heights[pos]);
          heap.add(new Node(pos, Math.max(curr.height, heights[pos])));
          visited[pos] = 1;
        }
      }
    }
    return sum;
  }
}
