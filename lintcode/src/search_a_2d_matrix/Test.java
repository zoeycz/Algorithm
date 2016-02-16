package search_a_2d_matrix;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(6);
    arr.add(5);
    Collections.reverse(arr);
    for (int x : arr) {
      System.out.println(x);
    }
  }
}
