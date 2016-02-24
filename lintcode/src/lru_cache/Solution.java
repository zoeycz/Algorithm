package lru_cache;

import java.util.HashMap;

public class Solution {
  class Node {
    int key;
    int val;
    Node prev, next;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private int capacity;
  private HashMap<Integer, Node> map;
  private Node head;
  private Node tail;

  public Solution(int capacity) {
    this.capacity = capacity;
    map = new HashMap<Integer, Node>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  // @return an integer
  public int get(int key) {
    if (map.get(key) == null) {
      return -1;
    }

    Node node = map.get(key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
    append(node);

    return node.val;
  }

  // @param key, an integer
  // @param value, an integer
  // @return nothing
  public void set(int key, int value) {
    // Note: Call get key to mark recently visited
    if (get(key) != -1) {
      map.get(key).val = value;
      return;
    }

    if (map.size() == capacity) {
      map.remove(head.next.key);
      head.next.next.prev = head;
      head.next = head.next.next;
    }

    Node node = new Node(key, value);
    map.put(key, node);
    append(node);
  }

  private void append(Node node) {
    node.next = tail;
    node.prev = tail.prev;
    tail.prev.next = node;
    tail.prev = node;
  }
}
