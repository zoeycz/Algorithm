package best_time_to_buy_and_sell_stock_iii;

class Solution {
  /**
   * @param prices: Given an integer array
   * @return: Maximum profit
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }
    int len = prices.length;

    // Two helper array for dp
    // Calculate left to right
    int[] left = new int[len];
    left[0] = 0;
    int min = prices[0];
    for (int i = 1; i < len; i++) {
      left[i] = Math.max(left[i - 1], prices[i] - min);
      min = Math.min(min, prices[i]);
    }

    // Calculate right to left
    int[] right = new int[len];
    right[len - 1] = 0;
    int max = prices[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], max - prices[i]);
      max = Math.max(max, prices[i]);
    }

    // Merge
    int rst = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      rst = Math.max(rst, left[i] + right[i]);
    }

    return rst;
  }
};
