package best_to_buy_and_sell_stock;

public class Solution {
  /**
   * @param prices: Given an integer array
   * @return: Maximum profit
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int buy = prices[0];
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] - buy > profit) {
        profit = prices[i] - buy;
      }
      if (prices[i] < buy) {
        buy = prices[i];
      }
    }

    return profit;
  }
}
