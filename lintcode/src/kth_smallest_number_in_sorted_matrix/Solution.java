package kth_smallest_number_in_sorted_matrix;

import java.util.PriorityQueue;

public class Solution {
  class Node implements Comparable<Node> {
    int x;
    int y;
    int val;

    Node(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    public int compareTo(Node n) {
      return val - n.val;
    }
  }

  /**
   * @param matrix: a matrix of integers
   * @param k: an integer
   * @return: the kth smallest number in the matrix
   */
  public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return -1;
    }

    // Initiate
    PriorityQueue<Node> heap = new PriorityQueue<>();
    for (int i = 0; i < Math.min(k, matrix.length); i++) {
      heap.add(new Node(i, 0, matrix[i][0]));
    }

    for (int i = 0; i < k - 1; i++) {
      Node n = heap.poll();
      if (n.y + 1 < matrix[0].length) {
        heap.add(new Node(n.x, n.y + 1, matrix[n.x][n.y + 1]));
      }
    }
    return heap.peek().val;
  }
}
