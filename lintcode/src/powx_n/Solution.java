package powx_n;

public class Solution {
  /**
   * @param x the base number
   * @param n the power number
   * @return the result
   */
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    boolean isNegative = false;
    if (n < 0) {
      isNegative = true;
      n = -n;
    }
    int i = n / 2;
    int j = n - i * 2;
    double p = myPow(x, i);
    double q = myPow(x, j);
    double rst = p * p * q;
    if (isNegative) {
      return 1 / rst;
    }
    return rst;
  }
}
