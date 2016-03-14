package product;

public class Solution {
  public int[] product(int[] arr) {
    int n = arr.length;
    int[] rst = new int[n];
    int[] p = new int[n];
    int[] q = new int[n];

    p[0] = 1;
    q[n - 1] = 1;
    for (int i = 1; i < n; i++) {
      p[i] = p[i - 1] * arr[i - 1];
      q[n - i - 1] = q[n - i] * arr[n - i];
    }

    for (int i = 0; i < n; i++) {
      rst[i] = p[i] * q[i];
    }

    return rst;
  }
}
